package g0803.bindingofshiba.gui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionTest {
    public Position getPosition() {
        return new Position(4, 5);
    }

    @Test
    public void getLeft() {
        Position position = getPosition();
        Assertions.assertEquals(new Position(3, 5), position.getDown());
    }

    @Test
    public void getRight() {
        Position position = getPosition();
        Assertions.assertEquals(new Position(5, 5), position.getDown());
    }

    @Test
    public void getUp() {
        Position position = getPosition();
        Assertions.assertEquals(new Position(4, 4), position.getDown());
    }

    @Test
    public void getDown() {
        Position position = getPosition();
        Assertions.assertEquals(new Position(4, 6), position.getDown());
    }

    @Test
    public void getNeighbours() {
        Position position = getPosition();
        List<Position> expected = new ArrayList<Position>(
                Arrays.asList(
                    new Position(2, 4),
                    new Position(3, 4),
                    new Position(4, 4),
                    new Position(2, 5),
                    new Position(4, 5),
                    new Position(2, 6),
                    new Position(3, 6),
                    new Position(4, 6)
                ));

        Assertions.assertEquals(expected, position.getNeighbours());
    };
}
