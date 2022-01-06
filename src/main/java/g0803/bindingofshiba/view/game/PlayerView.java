package g0803.bindingofshiba.view.game;

import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.elements.Player;

public class PlayerView {
    private Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    public void draw(GUI gui) {
        TextColor foregroundColor = TextColor.Factory.fromString("#FF00FF");
        TextColor backgroundColor = TextColor.Factory.fromString("#444444");

        gui.drawText(
                player.getPosition().getX(),
                player.getPosition().getY(),
                "X",
                foregroundColor,
                backgroundColor);
    }
}
