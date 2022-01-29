package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MonsterControllerTest {

    @Test
    public void movesTowardsPlayerIfFarAway() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getPosition()).thenReturn(new Vec2D(-1, 2));

        Monster monster = Mockito.mock(Monster.class);
        Mockito.when(monster.getPosition()).thenReturn(new Vec2D(500, 200));
        Mockito.when(monster.getVelocity()).thenReturn(Vec2D.zero());

        Game game = new Game(player, List.of(monster));

        MonsterController controller = new MonsterController(game, manager);
        controller.tick(app, 3);

        Mockito.verify(monster).setAcceleration(Mockito.argThat(vec -> vec.normalize().isSimilar(new Vec2D(-501, -198).normalize())));
    }

    @Test
    public void movesAwayFromPlayerIfNearby() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.getPosition()).thenReturn(new Vec2D(-1, 2));

        Monster monster = Mockito.mock(Monster.class);
        Mockito.when(monster.getPosition()).thenReturn(new Vec2D(3, 10));
        Mockito.when(monster.getVelocity()).thenReturn(Vec2D.zero());

        Game game = new Game(player, List.of(monster));

        MonsterController controller = new MonsterController(game, manager);
        controller.tick(app, 3);

        Mockito.verify(monster).move(3);
        Mockito.verify(monster).setAcceleration(Mockito.argThat(vec -> vec.normalize().isSimilar(new Vec2D(4, 8).normalize())));
    }
}
