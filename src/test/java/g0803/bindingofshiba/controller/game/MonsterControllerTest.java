package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.events.game.MonsterCollisionWithMonsterEvent;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        Mockito.verify(monster)
                .setAcceleration(
                        Mockito.argThat(
                                vec ->
                                        vec.normalize()
                                                .isSimilar(new Vec2D(-501, -198).normalize())));
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
        Mockito.verify(monster)
                .setAcceleration(
                        Mockito.argThat(
                                vec -> vec.normalize().isSimilar(new Vec2D(4, 8).normalize())));
    }

    @Test
    public void collisionWithMonster() {
        Monster monster1 = Mockito.mock(Monster.class);
        Monster monster2 = Mockito.mock(Monster.class);

        Game game = Mockito.mock(Game.class);
        EventManager manager = Mockito.mock(EventManager.class);

        MonsterController controller = new MonsterController(game, manager);
        Mockito.verify(manager).addObserver(controller);

        MonsterCollisionWithMonsterEvent event =
                new MonsterCollisionWithMonsterEvent(3, game, monster1, monster2);

        Mockito.when(monster1.getNextPosition(3)).thenReturn(new Vec2D(3, 4));
        Mockito.when(monster2.getNextPosition(3)).thenReturn(new Vec2D(6, 7));
        Mockito.when(monster1.getNextVelocity(3)).thenReturn(new Vec2D(3, 5));
        Mockito.when(monster2.getNextVelocity(3)).thenReturn(new Vec2D(8, 9));

        controller.onMonsterCollisionWithMonster(event);

        Mockito.verify(monster1)
                .setVelocity(Mockito.argThat(vec -> !vec.isSimilar(new Vec2D(3, 5))));
        Mockito.verify(monster2)
                .setVelocity(Mockito.argThat(vec -> !vec.isSimilar(new Vec2D(8, 9))));
    }

    @Test
    public void collisionWithPlayer() {
        Monster monster = Mockito.mock(Monster.class);
        Player player = Mockito.mock(Player.class);

        Game game = Mockito.mock(Game.class);
        EventManager manager = Mockito.mock(EventManager.class);

        MonsterController controller = new MonsterController(game, manager);
        Mockito.verify(manager).addObserver(controller);

        PlayerCollisionWithMonsterEvent event =
                new PlayerCollisionWithMonsterEvent(2, game, player, monster);

        Mockito.when(monster.getNextPosition(2)).thenReturn(new Vec2D(3, -2));
        Mockito.when(monster.getNextVelocity(2)).thenReturn(new Vec2D(-1, 0));

        controller.onPlayerCollisionWithMonster(event);

        Mockito.verify(monster).setVelocity(Vec2D.zero());
        Mockito.verify(monster).setAcceleration(Vec2D.zero());

        Mockito.verifyNoInteractions(player);
    }
}
