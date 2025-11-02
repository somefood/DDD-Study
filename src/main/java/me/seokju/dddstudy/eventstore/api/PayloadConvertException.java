package me.seokju.dddstudy.eventstore.api;

public class PayloadConvertException extends RuntimeException {
    public PayloadConvertException(Exception e) {
        super(e);
    }
}
