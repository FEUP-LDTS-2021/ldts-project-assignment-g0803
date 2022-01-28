package g0803.bindingofshiba.model.game;

import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final Player player;
    private final List<Monster> monsters;

    public Game() {
        this.player = new Player(new Vec2D(10, 20), 0, 30, 5);
        this.monsters = Arrays.asList(new Monster(new Vec2D(15, 40), 3, 1), new Monster(new Vec2D(10, 50), 5, 2));
    }

    public Game(Player player, List<Monster> monsters) {
        this.player = player;
        this.monsters = new ArrayList<>(monsters);
    }

    public Player getPlayer() {
        return player;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
