package g0803.bindingofshiba.events.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.Event;
import g0803.bindingofshiba.model.game.elements.Projectile;

public class ProjectileDestroyedEvent extends Event {

    private final Projectile projectile;

    public ProjectileDestroyedEvent(double dt, App app, Projectile projectile) {
        super(dt, app);

        this.projectile = projectile;
    }

    public Projectile getProjectile() {
        return projectile;
    }
}
