package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.model.game.Position;
import g0803.bindingofshiba.model.game.elements.Key;
import g0803.bindingofshiba.model.game.elements.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class KeyControllerTest {

    @Test
    void pickUpKeyByMoving() {
        Key key = new Key(new Position(6, 6));
        Player player = new Player(new Position(5, 5), 0, 5, 20);
        Keyboard keyboard = Mockito.mock(Keyboard.class);
        PlayerController playerController = new PlayerController(player, keyboard);

        KeyController keyController = new KeyController(key, player);

        // Simulate S key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.S)).thenReturn(true);

        playerController.movePlayer();
        keyController.pickUp();

        Assertions.assertEquals(false, key.getPickedUp());

        Mockito.reset(keyboard);

        // Simulate D key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.D)).thenReturn(true);
        playerController.movePlayer();
        keyController.pickUp();

        Assertions.assertEquals(true, key.getPickedUp());
    }

    @Test
    public void pickUpKeyByStanding() {
        Key key = new Key(new Position(6, 7));
        Player player = new Player(new Position(6, 7), 0, 20, 50);
        KeyController keyController = new KeyController(key, player);

        keyController.pickUp();

        Assertions.assertEquals(true, key.getPickedUp());
    }
}
