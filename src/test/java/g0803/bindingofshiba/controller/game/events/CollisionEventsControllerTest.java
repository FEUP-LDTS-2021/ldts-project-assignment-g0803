package g0803.bindingofshiba.controller.game.events;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.controller.game.GameController;
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
    public void tick() {
        App app = Mockito.mock(App.class);
        EventManager manager = Mockito.mock(EventManager.class);

        Controller<?> controller1 = Mockito.mock(Controller.class);
        Controller<?> controller2 = Mockito.mock(Controller.class);
        Controller<?> controller3 = Mockito.mock(Controller.class);

        Game game = Mockito.mock(Game.class);

        CollisionEventsController controller =
                new CollisionEventsController(game, manager, List.of(controller1, controller2, controller3));
        controller.tick(app, 3);

        Mockito.verify(controller1).tick(app, 3);
        Mockito.verify(controller2).tick(app, 3);
        Mockito.verify(controller3).tick(app, 3);
    }
}
