package g0803.bindingofshiba.controller.game.events;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.IEventManager;
import g0803.bindingofshiba.model.game.Game;

public class MonsterToObstacleCollisionEventsController extends Controller<Game> {

    public MonsterToObstacleCollisionEventsController(Game model, IEventManager eventManager) {
        super(model, eventManager);
    }

    @Override
    public void tick(App app, double dt) {
        throw new RuntimeException("not implemented");
    }
}
