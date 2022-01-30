package g0803.bindingofshiba.events.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.Event;

public class ProjectileDestroyedEvent extends Event {

    public ProjectileDestroyedEvent(double dt, App app) {
        super(dt, app);
    }
}
