package me.seokju.dddstudy.integration;

import me.seokju.dddstudy.eventstore.api.EventEntry;

public interface EventSender {
    void send(EventEntry event);
}
