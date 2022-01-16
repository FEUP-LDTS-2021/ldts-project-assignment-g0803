package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.elements.Player;
import g0803.bindingofshiba.view.View;

public class PlayerView extends View<Player> {

    public PlayerView(Player model) {
        super(model);
    }

    @Override
    public void draw(App app, GUI gui) {
        throw new RuntimeException("Not implemented");
    }
}
