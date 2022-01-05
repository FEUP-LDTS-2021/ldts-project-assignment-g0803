package g0803.bindingofshiba.controller.game;

import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.KeyStroke;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.gui.keyboard.LanternaKeyboard;
import g0803.bindingofshiba.model.game.Position;
import g0803.bindingofshiba.model.game.elements.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerControllerTest {

    public Player getPlayer() {
        return new Player(new Position(5, 5), 0, 50, 20);
    }


    @Test
    void movePlayer() {
        Player player = getPlayer();

        Keyboard keyboard = Mockito.mock(Keyboard.class);

        // Simulate A key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.A)).thenReturn(true);

        PlayerController playerController = new PlayerController(player, keyboard);
        playerController.movePlayer();

        Assertions.assertEquals(new Position(4, 5), player.getPosition());

        Mockito.reset(keyboard);

        // Simulate W key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.W)).thenReturn(true);
        playerController.movePlayer();

        Assertions.assertEquals(new Position(4, 4), player.getPosition());

        Mockito.reset(keyboard);

        // Simulate D key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.D)).thenReturn(true);
        playerController.movePlayer();

        Assertions.assertEquals(new Position(5, 4), player.getPosition());

        Mockito.reset(keyboard);

        // Simulate S key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.S)).thenReturn(true);
        playerController.movePlayer();

        Assertions.assertEquals(new Position(5, 5), player.getPosition());
    }
}