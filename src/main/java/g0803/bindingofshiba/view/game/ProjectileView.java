package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.IEventManager;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.elements.Projectile;
import g0803.bindingofshiba.view.View;

public class ProjectileView extends View<Projectile> {

    public ProjectileView(Projectile model, IEventManager eventManager) {
        super(model, eventManager);
    }

    @Override
    public void draw(App app, GUI gui, Vec2D offset) {
        throw new RuntimeException("Not implemented");
    }
}
