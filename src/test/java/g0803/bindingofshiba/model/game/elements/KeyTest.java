package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KeyTest {

    @Test
    public void pickUp() {
        Key key = new Key(new Position(6, 6));
        key.pickUp();
        Assertions.assertEquals(true, key.isPickedUp);
    }
}
