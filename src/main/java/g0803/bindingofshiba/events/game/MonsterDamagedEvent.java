package g0803.bindingofshiba.events.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.Event;
import g0803.bindingofshiba.model.game.elements.Monster;

public class MonsterDamagedEvent extends Event {

    private final Monster monster;

    public MonsterDamagedEvent(double dt, App app, Monster monster) {
        super(dt, app);

        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }
}
