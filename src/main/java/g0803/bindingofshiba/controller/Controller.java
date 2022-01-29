package g0803.bindingofshiba.controller;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.EventManager;

import java.io.IOException;

public abstract class Controller<T> {

    private final T model;
    private final EventManager eventManager;

    public Controller(T model, EventManager eventManager) {
        this.model = model;
        this.eventManager = eventManager;
    }

    public T getModel() {
        return model;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public abstract void tick(App app, double dt);
}
