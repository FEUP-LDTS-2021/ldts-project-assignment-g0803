package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;

public class PlayerController extends Controller<Game> {

    public PlayerController(Game model, EventManager eventManager) {
        super(model, eventManager);
    }

    private Vec2D getNextPlayerAcceleration(Keyboard keyboard, Vec2D currentVelocity) {
        Vec2D direction =
                switch (keyboard.getPressedKey()) {
                    case W -> Vec2D.up();
                    case S -> Vec2D.down();
                    case A -> Vec2D.left();
                    case D -> Vec2D.right();
                    default -> Vec2D.zero();
                };

        Vec2D force = direction.scale(200);
        Vec2D drag = currentVelocity.scale(4);

        return force.subtract(drag);
    }

    @Override
    public void tick(App app, double dt) {
        getModel().getPlayer().move(dt);
        getModel().getPlayer().setAcceleration(getNextPlayerAcceleration(app.getKeyboard(), getModel().getPlayer().getVelocity()));
    }
}
