package g0803.bindingofshiba.events;

import g0803.bindingofshiba.events.game.MonsterCollisionWithMonsterEvent;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EventManagerTest {

    @Test
    public void dispatchEventWithMultipleObservers() {
        IEventManager manager = new EventManager();

        Observer observer1 = Mockito.mock(Observer.class);
        Observer observer2 = Mockito.mock(Observer.class);

        manager.addObserver(observer1);
        manager.addObserver(observer2);

        MonsterCollisionWithMonsterEvent event1 =
                Mockito.mock(MonsterCollisionWithMonsterEvent.class);
        PlayerCollisionWithMonsterEvent event2 =
                Mockito.mock(PlayerCollisionWithMonsterEvent.class);

        manager.dispatchEvent(event1);
        manager.dispatchEvent(event2);

        Mockito.verify(observer1).onMonsterCollisionWithMonster(event1);
        Mockito.verify(observer1).onPlayerCollisionWithMonster(event2);
        Mockito.verify(observer2).onMonsterCollisionWithMonster(event1);
        Mockito.verify(observer2).onPlayerCollisionWithMonster(event2);
    }

    @Test
    public void removeObserver() {
        IEventManager manager = new EventManager();

        Observer observer = Mockito.mock(Observer.class);

        manager.addObserver(observer);
        manager.removeObserver(observer);

        MonsterCollisionWithMonsterEvent event1 =
                Mockito.mock(MonsterCollisionWithMonsterEvent.class);
        PlayerCollisionWithMonsterEvent event2 =
                Mockito.mock(PlayerCollisionWithMonsterEvent.class);

        manager.dispatchEvent(event1);
        manager.dispatchEvent(event2);

        Mockito.verifyNoInteractions(observer);
    }
}
