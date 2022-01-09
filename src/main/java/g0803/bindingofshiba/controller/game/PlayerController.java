package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.model.game.Position;
import g0803.bindingofshiba.model.game.elements.Player;

import java.io.IOException;

public class PlayerController extends Controller<Player> {
    private Keyboard keyboard;

    public PlayerController(Player model, Keyboard keyboard) {
        super(model);
        this.keyboard = keyboard;
    }

    public void movePlayer() {
        this.getModel().setPosition(getNextPosition());
    }

    public Position getNextPosition() {
        Position playerPos = this.getModel().getPosition();

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

    @Override
    public void tick(App app) throws IOException {}
}