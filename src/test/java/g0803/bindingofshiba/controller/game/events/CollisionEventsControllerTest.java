package g0803.bindingofshiba.controller.game.events;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.events.game.MonsterCollisionWithMonsterEvent;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import g0803.bindingofshiba.math.BoundingBox;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CollisionEventsControllerTest {

    @Test
    public void playerCollidingWithMonster() {
        App app = Mockito.mock(App.class);

        Bundle<BoundingBox> boundingBoxes = Mockito.mock(Bundle.class);
        Mockito.when(boundingBoxes.get("shiba")).thenReturn(new BoundingBox(-5, -4, 10, 8));
        Mockito.when(boundingBoxes.get("monster")).thenReturn(new BoundingBox(-3, -5, 6, 10));

        Mockito.when(app.getBoundingBoxes()).thenReturn(boundingBoxes);

        Player player = Mockito.mock(Player.class);
        Monster monster = Mockito.mock(Monster.class);

        Mockito.when(player.getNextPosition(3)).thenReturn(new Vec2D(13, 1));
        Mockito.when(monster.getNextPosition(3)).thenReturn(new Vec2D(14, 0));

        EventManager manager = Mockito.mock(EventManager.class);
        Game game = new Game(player, List.of(monster));
        CollisionEventsController controller = new CollisionEventsController(game, manager);

        controller.tick(app, 3);

        Mockito.verify(manager)
                .dispatchEvent(
                        Mockito.argThat(
                                event -> {
                                    if (!(event instanceof PlayerCollisionWithMonsterEvent e))
                                        return false;

                                    return e.getPlayer() == player
                                            && e.getMonster() == monster
                                            && e.getTickTime() == 3;
                                }));
    }

    @Test
    public void playerNotCollidingWithMonster() {
        App app = Mockito.mock(App.class);

        Bundle<BoundingBox> boundingBoxes = Mockito.mock(Bundle.class);
        Mockito.when(boundingBoxes.get("shiba")).thenReturn(new BoundingBox(-5, -4, 10, 8));
        Mockito.when(boundingBoxes.get("monster")).thenReturn(new BoundingBox(-3, -5, 6, 10));

        Mockito.when(app.getBoundingBoxes()).thenReturn(boundingBoxes);

        Player player = Mockito.mock(Player.class);
        Monster monster = Mockito.mock(Monster.class);

        Mockito.when(player.getNextPosition(4)).thenReturn(new Vec2D(13, 1));
        Mockito.when(monster.getNextPosition(4)).thenReturn(new Vec2D(18, 14));

        EventManager manager = Mockito.mock(EventManager.class);
        Game game = new Game(player, List.of(monster));
        CollisionEventsController controller = new CollisionEventsController(game, manager);

        controller.tick(app, 4);

        Mockito.verifyNoInteractions(manager);
    }

    @Test
    public void monsterCollidingWithMonster() {
        App app = Mockito.mock(App.class);

        Bundle<BoundingBox> boundingBoxes = Mockito.mock(Bundle.class);
        Mockito.when(boundingBoxes.get("shiba")).thenReturn(new BoundingBox(-5, -4, 10, 8));
        Mockito.when(boundingBoxes.get("monster")).thenReturn(new BoundingBox(-3, -5, 6, 10));

        Mockito.when(app.getBoundingBoxes()).thenReturn(boundingBoxes);

        Player player = Mockito.mock(Player.class);
        Monster monster1 = Mockito.mock(Monster.class);
        Monster monster2 = Mockito.mock(Monster.class);

        Mockito.when(player.getNextPosition(4)).thenReturn(new Vec2D(13, 1));
        Mockito.when(monster1.getNextPosition(4)).thenReturn(new Vec2D(18, 14));
        Mockito.when(monster2.getNextPosition(4)).thenReturn(new Vec2D(20, 15));

        EventManager manager = Mockito.mock(EventManager.class);
        Game game = new Game(player, List.of(monster1, monster2));
        CollisionEventsController controller = new CollisionEventsController(game, manager);

        controller.tick(app, 4);

        Mockito.verify(manager)
                .dispatchEvent(
                        Mockito.argThat(
                                event -> {
                                    if (!(event instanceof MonsterCollisionWithMonsterEvent e))
                                        return false;

                                    return ((e.getFirstMonster() == monster1
                                                            && e.getSecondMonster() == monster2)
                                                    || (e.getFirstMonster() == monster2
                                                            && e.getSecondMonster() == monster1))
                                            && e.getTickTime() == 4;
                                }));
    }

    @Test
    public void monstersNotCollidingWithMonsters() {
        App app = Mockito.mock(App.class);

        Bundle<BoundingBox> boundingBoxes = Mockito.mock(Bundle.class);
        Mockito.when(boundingBoxes.get("shiba")).thenReturn(new BoundingBox(-5, -4, 10, 8));
        Mockito.when(boundingBoxes.get("monster")).thenReturn(new BoundingBox(-3, -5, 6, 10));

        Mockito.when(app.getBoundingBoxes()).thenReturn(boundingBoxes);

        Player player = Mockito.mock(Player.class);
        Monster monster1 = Mockito.mock(Monster.class);
        Monster monster2 = Mockito.mock(Monster.class);

        Mockito.when(player.getNextPosition(2)).thenReturn(new Vec2D(13, 1));
        Mockito.when(monster1.getNextPosition(2)).thenReturn(new Vec2D(18, 14));
        Mockito.when(monster2.getNextPosition(2)).thenReturn(new Vec2D(5, 34));

        EventManager manager = Mockito.mock(EventManager.class);
        Game game = new Game(player, List.of(monster1, monster2));
        CollisionEventsController controller = new CollisionEventsController(game, manager);

        controller.tick(app, 2);

        Mockito.verifyNoInteractions(manager);
    }
}
