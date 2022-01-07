package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.model.game.Game;
import java.io.IOException;

public class GameController extends Controller<Game> {

    public GameController(Game model) {
        super(model);
    }

    @Override
    public void tick(App app) throws IOException {}
}
