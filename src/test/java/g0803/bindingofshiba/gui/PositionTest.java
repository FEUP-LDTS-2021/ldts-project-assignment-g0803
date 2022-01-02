package g0803.bindingofshiba.gui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PositionTest {
    public Position getPosition() {
        return new Position(4, 5);
    }

    @Test
    public void getLeft() {
        Position position = getPosition();
        Position left = position.getLeft();

        Assertions.assertEquals(3, left.getX());
        Assertions.assertEquals(5, left.getY());
    }

    @Test
    public void getRight() {
        Position position = getPosition();
        Position right = position.getRight();

        Assertions.assertEquals(5, right.getX());
        Assertions.assertEquals(5, right.getY());
    }

    @Test
    public void getUp() {
        Position position = getPosition();
        Position up = position.getUp();

        Assertions.assertEquals(4, up.getX());
        Assertions.assertEquals(4, up.getY());
    }

    @Test
    public void getDown() {
        Position position = getPosition();
        Position down = position.getDown();

        Assertions.assertEquals(4, down.getX());
        Assertions.assertEquals(6, down.getY());
    }

    @Test
    public void getNeighbours() {
        Position position = getPosition();
        List<Position> neighbours = position.getNeighbours();
        List<Position> expected = Arrays.asList(
                new Position(3, 4),
                new Position(4, 4),
                new Position(5, 4),
                new Position(3, 5),
                new Position(5, 5),
                new Position(3, 6),
                new Position(4, 6),
                new Position(5, 6)
        );


        boolean equal = true;


        for (Position pos : expected) {
            if (!neighbours.contains(pos))
                Assertions.fail();
        }
    };
}
