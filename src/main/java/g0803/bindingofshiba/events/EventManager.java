package g0803.bindingofshiba.events;

import java.util.*;

public class EventManager implements IEventManager {

    @Override
    public void addObserver(Observer observer) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void removeObserver(Observer observer) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Set<Observer> getObservers() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void dispatchEvent(Event event) {
        throw new RuntimeException("Not implemented");
    }
}
