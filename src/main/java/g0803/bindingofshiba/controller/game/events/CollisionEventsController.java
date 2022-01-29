package g0803.bindingofshiba.controller.game.events;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.events.game.MonsterCollisionWithMonsterEvent;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import g0803.bindingofshiba.math.BoundingBox;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollisionEventsController extends Controller<Game> {

    public CollisionEventsController(Game model, EventManager eventManager) {
        super(model, eventManager);
    }

    private void handleMonsterToMonsterCollisions(Bundle<BoundingBox> boundingBoxes, double dt) {
        List<Monster> monsters = getModel().getMonsters();
        ArrayList<MonsterCollisionWithMonsterEvent> eventsToDispatch = new ArrayList<>();

        BoundingBox monsterBox = boundingBoxes.get("monster");
        for (int i = 0; i < monsters.size() - 1; i++) {
            Monster monster1 = monsters.get(i);

            for (int j = i + 1; j < monsters.size(); j++) {
                Monster monster2 = monsters.get(j);

                BoundingBox monsterBox1 = monsterBox.translate(monster1.getNextPosition(dt));
                BoundingBox monsterBox2 = monsterBox.translate(monster2.getNextPosition(dt));
                if (monsterBox1.collides(monsterBox2))
                    eventsToDispatch.add(new MonsterCollisionWithMonsterEvent(dt, getModel(), monster1, monster2));
            }
        }

        for (MonsterCollisionWithMonsterEvent event : eventsToDispatch)
            getEventManager().dispatchEvent(event);
    }

    private void handlePlayerToMonsterCollisions(Bundle<BoundingBox> boundingBoxes, double dt) {
        Player player = getModel().getPlayer();
        List<Monster> monsters = getModel().getMonsters();
        ArrayList<PlayerCollisionWithMonsterEvent> eventsToDispatch = new ArrayList<>();

        BoundingBox playerBox = boundingBoxes.get("shiba");
        BoundingBox monsterBox = boundingBoxes.get("monster");
        for (Monster monster : monsters) {
            BoundingBox playerBoundingBox = playerBox.translate(player.getNextPosition(dt));
            BoundingBox monsterBoundingBox = monsterBox.translate(monster.getNextPosition(dt));

            if (playerBoundingBox.collides(monsterBoundingBox))
                eventsToDispatch.add(new PlayerCollisionWithMonsterEvent(dt, getModel(), player, monster));
        }

        for (PlayerCollisionWithMonsterEvent event : eventsToDispatch)
            getEventManager().dispatchEvent(event);
    }

    @Override
    public void tick(App app, double dt) {
        Bundle<BoundingBox> boundingBoxes = app.getBoundingBoxes();

        handleMonsterToMonsterCollisions(boundingBoxes, dt);
        handlePlayerToMonsterCollisions(boundingBoxes, dt);
    }
}
