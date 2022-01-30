package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.IEventManager;
import g0803.bindingofshiba.events.Observer;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Player;

public class PlayerController extends Controller<Game> implements Observer {

    public PlayerController(Game model, IEventManager eventManager) {
        super(model, eventManager);
        eventManager.addObserver(this);
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
        getModel()
                .getPlayer()
                .setAcceleration(
                        getNextPlayerAcceleration(
                                app.getKeyboard(), getModel().getPlayer().getVelocity()));
    }

    @Override
    public void onPlayerCollisionWithMonster(PlayerCollisionWithMonsterEvent event) {
        Player player = event.getPlayer();
        player.setAcceleration(Vec2D.zero());
        player.setVelocity(Vec2D.zero());
    }
}
