package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.model.game.Game;

public class MonsterController extends Controller<Game> {

    public MonsterController(Game model, EventManager eventManager) {
        super(model, eventManager);
    }

    @Override
    public void tick(App app, double dt) {
        throw new RuntimeException("Not implemented");
    }
}
