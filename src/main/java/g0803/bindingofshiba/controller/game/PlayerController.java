package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.model.game.Position;
import g0803.bindingofshiba.model.game.elements.Player;

public class PlayerController {
    private Player player;
    private Keyboard keyboard;

    public PlayerController(Player player, Keyboard keyboard) {
        this.player = player;
        this.keyboard = keyboard;
    }

    public void movePlayer() {

    }

    public Position getNextPosition() {
        return new Position(0, 0);
    }
}
