package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.events.Observer;
import g0803.bindingofshiba.events.game.MonsterCollisionWithMonsterEvent;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;

public class MonsterController extends Controller<Game> implements Observer {

    public MonsterController(Game model, EventManager eventManager) {
        super(model, eventManager);
    }

    private Vec2D getNextMonsterAcceleration(Monster monster) {
        Vec2D playerPosition = getModel().getPlayer().getPosition();
        Vec2D seekVector = playerPosition.subtract(monster.getPosition());
        Vec2D direction = seekVector.normalize();

        if (seekVector.getLengthSquared() < 225) direction = direction.scale(-1);

        Vec2D force = direction.scale(4);
        Vec2D drag = monster.getVelocity().scale(0.25);

        return force.subtract(drag);
    }

    @Override
    public void tick(App app, double dt) {
        for (Monster monster : getModel().getMonsters()) {
            monster.move(dt);
            monster.setAcceleration(getNextMonsterAcceleration(monster));
        }
    }

    @Override
    public void onMonsterCollisionWithMonster(MonsterCollisionWithMonsterEvent event) {
    }

    @Override
    public void onPlayerCollisionWithMonster(PlayerCollisionWithMonsterEvent event) {
    }
}
