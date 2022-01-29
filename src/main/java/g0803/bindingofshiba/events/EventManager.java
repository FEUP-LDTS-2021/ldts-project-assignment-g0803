package g0803.bindingofshiba.events;

import g0803.bindingofshiba.events.game.MonsterCollisionWithMonsterEvent;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import java.util.*;

public class EventManager implements IEventManager {

    private final Set<Observer> observers = new HashSet<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public Set<Observer> getObservers() {
        return observers;
    }

    private void dispatchEvent(Event event, Observer listener) {
        if (event instanceof PlayerCollisionWithMonsterEvent e) {
            listener.onPlayerCollisionWithMonster(e);
        } else if (event instanceof MonsterCollisionWithMonsterEvent e) {
            listener.onMonsterCollisionWithMonster(e);
        }
    }

    @Override
    public void dispatchEvent(Event event) {
        for (Observer observer : observers) {
            dispatchEvent(event, observer);
        }
    }
}
