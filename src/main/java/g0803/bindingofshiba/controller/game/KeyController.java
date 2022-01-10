package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.model.game.elements.Key;
import g0803.bindingofshiba.model.game.elements.Player;

import java.io.IOException;

public class KeyController extends Controller<Key> {
    private final Player player;

    public KeyController(Key model, Player player) {
        super(model);
        this.player = player;
    }

    public void pickUp() {
        if (player.getPosition().equals(getModel().getPosition()))
            getModel().pickUp();
    }

    @Override
    public void tick(App app) throws IOException {
    }
}
