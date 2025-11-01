package me.seokju.dddstudy.lock;

public class LockingFailException extends LockException {
    public LockingFailException() {
    }

    public LockingFailException(Exception cause) {
        super(cause);
    }
}
