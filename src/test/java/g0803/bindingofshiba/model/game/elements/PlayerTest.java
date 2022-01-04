package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PlayerTest {

    public Player getPlayer() {
        return new Player(new Position(5, 5), 0, 50, 20);
    }

    @Test
    public void decreaseHp() {
        Player player = getPlayer();
        player.decreaseHpByAmount(20);
        Assertions.assertEquals(30,  player.getHp());
        player.decreaseHpByAmount(10);
        Assertions.assertEquals(20, player.getHp());

        Assertions.assertTrue(player.isAlive());

        player.decreaseHpByAmount(20);
        Assertions.assertEquals(0, player.getHp());

        Assertions.assertFalse(player.isAlive());
    }

    @Test
    public void decreaseHpByAmountLargerThanHealth() {
        Player player = getPlayer();
        player.decreaseHpByAmount(100);
        Assertions.assertEquals(0, player.getHp());
        Assertions.assertFalse(player.isAlive());
    }

    @Test
    public void decreaseHpByNegativeNumber() {
        Player player = getPlayer();
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                player.decreaseHpByAmount(-2);
            }
        });
    }

    @Test
    public void killPlayer() {
        Player player = getPlayer();
        player.decreaseHpByAmount(50);
        Assertions.assertFalse(player.isAlive());
    }

    @Test
    public void pickKeys() {
        Player player = getPlayer();
        player.pickKey();
        player.pickKey();
        player.pickKey();
        Assertions.assertEquals(3, player.getNumberOfKeys());
    }
}