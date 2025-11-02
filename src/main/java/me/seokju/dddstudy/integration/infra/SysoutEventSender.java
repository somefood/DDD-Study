package me.seokju.dddstudy.integration.infra;

import me.seokju.dddstudy.eventstore.api.EventEntry;
import me.seokju.dddstudy.integration.EventSender;
import org.springframework.stereotype.Component;

@Component
public class SysoutEventSender implements EventSender {
    @Override
    public void send(EventEntry event) {
        System.out.println("EventSender send event : " + event);
    }
}
