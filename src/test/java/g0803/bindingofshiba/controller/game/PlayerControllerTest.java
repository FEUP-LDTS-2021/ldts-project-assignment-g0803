package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class PlayerControllerTest {

    @Test
    public void movesAccordingToInputUp() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);
        Keyboard keyboard = Mockito.mock(Keyboard.class);

        Mockito.when(keyboard.getPressedKey()).thenReturn(Keyboard.Key.W);
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.W)).thenReturn(true);
        Mockito.when(app.getKeyboard()).thenReturn(keyboard);

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getVelocity()).thenReturn(Vec2D.zero());

        Game game = new Game(player, List.of());
        PlayerController playerController = new PlayerController(game, manager);

        playerController.tick(app, 2);

        Mockito.verify(player).move(2);
        Mockito.verify(player).setAcceleration(Mockito.argThat(vec -> vec.normalize().isSimilar(Vec2D.up())));
    }

    @Test
    public void movesAccordingToInputDown() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);
        Keyboard keyboard = Mockito.mock(Keyboard.class);

        Mockito.when(keyboard.getPressedKey()).thenReturn(Keyboard.Key.S);
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.S)).thenReturn(true);
        Mockito.when(app.getKeyboard()).thenReturn(keyboard);

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getVelocity()).thenReturn(Vec2D.zero());

        Game game = new Game(player, List.of());
        PlayerController playerController = new PlayerController(game, manager);

        playerController.tick(app, 3);

        Mockito.verify(player).move(3);
        Mockito.verify(player).setAcceleration(Mockito.argThat(vec -> vec.normalize().isSimilar(Vec2D.down())));
    }

    @Test
    public void movesAccordingToInputLeft() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);
        Keyboard keyboard = Mockito.mock(Keyboard.class);

        Mockito.when(keyboard.getPressedKey()).thenReturn(Keyboard.Key.A);
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.A)).thenReturn(true);
        Mockito.when(app.getKeyboard()).thenReturn(keyboard);

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getVelocity()).thenReturn(Vec2D.zero());

        Game game = new Game(player, List.of());
        PlayerController playerController = new PlayerController(game, manager);

        playerController.tick(app, 2);

        Mockito.verify(player).move(2);
        Mockito.verify(player).setAcceleration(Mockito.argThat(vec -> vec.normalize().isSimilar(Vec2D.left())));
    }

    @Test
    public void movesAccordingToInputRight() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);
        Keyboard keyboard = Mockito.mock(Keyboard.class);

        Mockito.when(keyboard.getPressedKey()).thenReturn(Keyboard.Key.D);
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.D)).thenReturn(true);
        Mockito.when(app.getKeyboard()).thenReturn(keyboard);

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getVelocity()).thenReturn(Vec2D.zero());

        Game game = new Game(player, List.of());
        PlayerController playerController = new PlayerController(game, manager);

        playerController.tick(app, 2);

        Mockito.verify(player).move(2);
        Mockito.verify(player).setAcceleration(Mockito.argThat(vec -> vec.normalize().isSimilar(Vec2D.right())));
    }

    @Test
    public void doesntMoveWithNoInput() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);
        Keyboard keyboard = Mockito.mock(Keyboard.class);

        Mockito.when(keyboard.getPressedKey()).thenReturn(Keyboard.Key.NONE);
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.NONE)).thenReturn(true);
        Mockito.when(app.getKeyboard()).thenReturn(keyboard);

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getVelocity()).thenReturn(Vec2D.zero());

        Game game = new Game(player, List.of());
        PlayerController playerController = new PlayerController(game, manager);

        playerController.tick(app, 2);

        Mockito.verify(player).move(2);
        Mockito.verify(player).setAcceleration(Mockito.argThat(vec -> vec.isSimilar(Vec2D.zero())));
    }
}
