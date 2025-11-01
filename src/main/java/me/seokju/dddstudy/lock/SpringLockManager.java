package me.seokju.dddstudy.lock;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SpringLockManager implements LockManager {
    private final int lockTimeout = 5 * 60 * 1000; // 5 minutes
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<LockData> lockDataRowMapper = (rs, rowNum) ->
            new LockData(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getTimestamp(4).getTime());

    @Transactional
    @Override
    public LockId tryLock(String type, String id) throws LockException {
        checkAlreadyLocked(type, id);
        LockId lockId = new LockId(UUID.randomUUID().toString());
        locking(type, id, lockId);
        return lockId;
    }

    private void checkAlreadyLocked(String type, String id) {
        List<LockData> locks = jdbcTemplate.query(
                "select * from locks where type = ? and id = ?",
                lockDataRowMapper, type, id
        );
        Optional<LockData> lockData = handleExpiration(locks);
        if (lockData.isPresent()) throw new AlreadyLockedException();
    }

    private Optional<LockData> handleExpiration(List<LockData> locks) {
        if (locks.isEmpty()) return Optional.empty();
        LockData lockData = locks.getFirst();
        if (lockData.isExpired()) {
            jdbcTemplate.update(
                    "delete from locks where type = ? and id = ?",
                    lockData.type(), lockData.id()
            );
            return Optional.empty();
        } else {
            return Optional.of(lockData);
        }
    }

    private void locking(String type, String id, LockId lockId) {
        try {
            int updatedCount = jdbcTemplate.update(
                    "insert into locks values (?, ?, ?, ?)",
                    type, id, lockId.value(), new Timestamp(getExpirationTime())
            );
            if (updatedCount == 0) throw new LockingFailException();
        } catch (DuplicateKeyException e) {
            throw new LockingFailException(e);
        }
    }

    private long getExpirationTime() {
        return System.currentTimeMillis() + lockTimeout;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void checkLock(LockId lockId) throws LockException {
        Optional<LockData> lockData = getLockData(lockId);
        if (lockData.isEmpty()) throw new NoLockException();
    }

    private Optional<LockData> getLockData(LockId lockId) {
        List<LockData> locks = jdbcTemplate.query(
                "select * from locks where lockid = ?",
                lockDataRowMapper, lockId.value());
        return handleExpiration(locks);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void releaseLock(LockId lockId) throws LockException {
        jdbcTemplate.update("delete from locks where lockid = ?", lockId.value());
    }

    @Override
    public void extendLockExpiration(LockId lockId, long inc) throws LockException {
        Optional<LockData> lockDataOpt = getLockData(lockId);
        LockData lockData = lockDataOpt.orElseThrow(NoLockException::new);
        jdbcTemplate.update(
                "update locks set expiration_time = ? where type = ? and id = ?",
                new Timestamp(lockData.timestamp() + inc),
                lockData.type(), lockData.id()
        );
    }
}
