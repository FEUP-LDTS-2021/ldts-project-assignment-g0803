package g0803.bindingofshiba.events.game;

import g0803.bindingofshiba.events.Event;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;

public class MonsterCollisionWithMonsterEvent extends Event {

    private final Game game;
    private final Monster monster1, monster2;

    public MonsterCollisionWithMonsterEvent(Game game, Monster monster1, Monster monster2) {
        this.game = game;
        this.monster1 = monster1;
        this.monster2 = monster2;
    }

    public Game getGame() {
        return game;
    }

    public Monster getFirstMonster() {
        return monster1;
    }

    public Monster getSecondMonster() {
        return monster2;
    }
}