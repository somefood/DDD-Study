package me.seokju.dddstudy.lock;

public record LockData(String type, String id, String lockId, long timestamp) {

    public boolean isExpired() {
        return timestamp < System.currentTimeMillis();
    }
}
