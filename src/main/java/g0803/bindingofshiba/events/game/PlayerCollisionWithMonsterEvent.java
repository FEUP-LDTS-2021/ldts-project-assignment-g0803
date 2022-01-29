package g0803.bindingofshiba.events.game;

import g0803.bindingofshiba.events.Event;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;

public class PlayerCollisionWithMonsterEvent extends Event {

    private final Game game;
    private final Player player;
    private final Monster monster;

    public PlayerCollisionWithMonsterEvent(double dt, Game game, Player player, Monster monster) {
        super(dt);
        this.game = game;
        this.player = player;
        this.monster = monster;
    }

    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

    public Monster getMonster() {
        return monster;
    }
}
