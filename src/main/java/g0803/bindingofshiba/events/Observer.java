package g0803.bindingofshiba.events;

import g0803.bindingofshiba.events.game.MonsterCollisionWithMonsterEvent;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;

public interface Observer {

    default void onPlayerCollisionWithMonster(PlayerCollisionWithMonsterEvent event) {}
    default void onMonsterCollisionWithMonster(MonsterCollisionWithMonsterEvent event) {}
}
