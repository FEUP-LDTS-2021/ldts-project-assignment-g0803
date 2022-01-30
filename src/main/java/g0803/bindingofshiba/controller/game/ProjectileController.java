package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.IEventManager;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Projectile;

public class ProjectileController extends Controller<Game> {

    public ProjectileController(Game model, IEventManager eventManager) {
        super(model, eventManager);
    }

    private void spawnProjectilesIfNeeded(Keyboard keyboard) {
        Vec2D direction = switch (keyboard.getPressedKey()) {
            case ARROW_UP -> Vec2D.up();
            case ARROW_DOWN -> Vec2D.down();
            case ARROW_LEFT -> Vec2D.left();
            case ARROW_RIGHT -> Vec2D.right();
            default -> null;
        };

        if (direction == null) return;

        Projectile projectile = new Projectile(getModel().getPlayer().getPosition().add(new Vec2D(0, -2)), getModel().getPlayer().getDamage());
        Vec2D playerVelocity = getModel().getPlayer().getVelocity();

        if (playerVelocity.getLengthSquared() < 16) {
            playerVelocity = Vec2D.zero();
        } else {
            playerVelocity = playerVelocity.normalize();
        }

        projectile.setVelocity(playerVelocity.add(direction.scale(4)).normalize().scale(20));
        getModel().getCurrentRoom().addProjectile(projectile);
    }

    private void moveProjectiles(double dt) {
        for (Projectile projectile : getModel().getCurrentRoom().getProjectiles()) {
            projectile.move(dt);
        }
    }

    @Override
    public void tick(App app, double dt) {
        Keyboard keyboard = app.getKeyboard();
        moveProjectiles(dt);
        spawnProjectilesIfNeeded(keyboard);
    }
}
