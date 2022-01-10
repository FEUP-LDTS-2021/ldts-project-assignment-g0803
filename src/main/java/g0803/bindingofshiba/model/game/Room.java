package g0803.bindingofshiba.model.game;

import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Obstacle;

import java.util.List;

public class Room {
    private int width;
    private int height;
    private List<Monster> monsters;
    private List<Door> doors;
    private List<Obstacle> obstacles;

    Room(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    public List<Door> getDoors() {
        return this.doors;
    }
}
