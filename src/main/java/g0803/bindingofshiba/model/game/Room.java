package g0803.bindingofshiba.model.game;

import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Obstacle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private int width;
    private int height;
    private List<Monster> monsters;

    public Room(int width, int height, List<Monster> monsters, List<Obstacle> obstacles) {
        throw new RuntimeException("Not implemented");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Obstacle> getObstacles() {
        throw new RuntimeException("Not implemented");
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    public Map<DoorPosition, Door> getDoors() {
        throw new RuntimeException("Not implemented");
    }

    public void addDoor(Door door) {
        throw new RuntimeException("Not implemented");
    }
}
