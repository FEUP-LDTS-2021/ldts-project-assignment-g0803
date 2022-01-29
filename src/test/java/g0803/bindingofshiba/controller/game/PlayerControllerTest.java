package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
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

    @Test
    public void collisionWithMonster() {
        Monster monster = Mockito.mock(Monster.class);
        Player player = Mockito.mock(Player.class);

        Game game = Mockito.mock(Game.class);
        EventManager manager = Mockito.mock(EventManager.class);

        PlayerController controller = new PlayerController(game, manager);
        Mockito.verify(manager).addObserver(controller);

        PlayerCollisionWithMonsterEvent event = new PlayerCollisionWithMonsterEvent(2, game, player, monster);

        Mockito.when(player.getNextPosition(2)).thenReturn(new Vec2D(1, 3));
        Mockito.when(player.getNextVelocity(2)).thenReturn(new Vec2D(45, 7));

        controller.onPlayerCollisionWithMonster(event);

        Mockito.verify(player).setVelocity(Vec2D.zero());
        Mockito.verify(player).setAcceleration(Vec2D.zero());

        Mockito.verifyNoInteractions(monster);
    }
}
