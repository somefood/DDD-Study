package me.seokju.dddstudy.common.event;

import me.seokju.dddstudy.eventstore.api.EventStore;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventStoreHandler {
    private final EventStore eventStore;

    public EventStoreHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @EventListener(Event.class)
    public void handle(Event event) {
        eventStore.save(event);
    }
}
