package me.seokju.dddstudy.integration;

public interface OffsetStore {
    long get();
    void update(long nextOffset);
}
