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
        player.setPosition(getNextPosition());
    }

    public Position getNextPosition() {
        Position playerPos = player.getPosition();

        if (keyboard.isKeyPressed(Keyboard.Key.A)) {
            return playerPos.getLeft();
        } else if (keyboard.isKeyPressed(Keyboard.Key.W)) {
            return playerPos.getUp();
        } else if (keyboard.isKeyPressed(Keyboard.Key.S)) {
            return playerPos.getDown();
        } else if (keyboard.isKeyPressed(Keyboard.Key.D)) {
            return playerPos.getRight();
        }
        return playerPos;
    }
}
