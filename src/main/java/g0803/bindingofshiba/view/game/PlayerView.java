package g0803.bindingofshiba.view.game;

import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.elements.Player;
import g0803.bindingofshiba.view.View;

public class PlayerView extends View<Player> {

    public PlayerView(Player model) {
        super(model);
    }

    @Override
    public void draw(GUI gui) {
        TextColor foregroundColor = TextColor.Factory.fromString("#FF00FF");
        TextColor backgroundColor = TextColor.Factory.fromString("#444444");

        gui.drawText(
                this.getModel().getPosition().getX(),
                this.getModel().getPosition().getY(),
                "X",
                foregroundColor,
                backgroundColor);
    }
}
