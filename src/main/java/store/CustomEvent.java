package store;

import javafx.event.Event;
import javafx.event.EventType;


public class CustomEvent extends Event {
    public CustomEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public static final EventType<CustomEvent> GO_TO_CREATE_SCENE = new EventType<>("GO_TO_CREATE_SCENE");
    public static final EventType<CustomEvent> GO_TO_OVERVIEW_SCENE = new EventType<>("GO_TO_OVERVIEW_SCENE");
    public static final EventType<CustomEvent> GO_TO_EDIT_SCENE = new EventType<>("GO_TO_EDIT_SCENE");



}
