package g0803.bindingofshiba.gui;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getLeft() {
        return new Position(0, 0);
    }

    public Position getRight() {
        return new Position(0, 0);
    }

    public Position getUp() {
        return new Position(0, 0);
    }

    public Position getDown() {
        return new Position(0, 0);
    }

    public List<Position> getNeighbours() {
        return new ArrayList<>();
    }
}
