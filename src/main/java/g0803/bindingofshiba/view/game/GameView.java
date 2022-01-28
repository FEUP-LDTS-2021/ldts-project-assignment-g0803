package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.factory.ViewFactory;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;
import g0803.bindingofshiba.view.View;


public class GameView extends View<Game> {

    public GameView(Game model, ViewFactory<Player> playerViewFactory, ViewFactory<Monster> monsterViewFactory) {
        super(model);

        throw new RuntimeException("Not implemented");
    }

    @Override
    public void draw(App app, GUI gui, Vec2D offset) {

    }
}
