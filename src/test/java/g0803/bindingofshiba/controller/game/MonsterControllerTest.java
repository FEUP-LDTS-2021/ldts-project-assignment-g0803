package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.model.game.Monster;
import g0803.bindingofshiba.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MonsterControllerTest {
    public Monster getMonster() {
        return new Monster(new Position(5, 6), 50, 20);
    }

    @Test
    public void moveMonsterToTargetAhead() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(new Position(10, 10));
        Assertions.assertEquals(new Position(6, 7), monster.getPosition());
        monsterController.tick(new Position(10, 1));
        Assertions.assertEquals(new Position(7, 6), monster.getPosition());

        monsterController.tick(new Position(10, 6));
        Assertions.assertEquals(new Position(8, 6), monster.getPosition());
    }

    @Test
    public void moveMonsterToTargetBehind() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(new Position(1, 1));
        Assertions.assertEquals(new Position(4, 5), monster.getPosition());

        monsterController.tick(new Position(1, 10));
        Assertions.assertEquals(new Position(3, 6), monster.getPosition());

        monsterController.tick(new Position(1, 6));
        Assertions.assertEquals(new Position(2, 6), monster.getPosition());
    }

    @Test
    public void moveMonsterToTargetAbove() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(new Position(10, 1));
        Assertions.assertEquals(new Position(6, 5), monster.getPosition());

        monsterController.tick(new Position(1, 1));
        Assertions.assertEquals(new Position(5, 4), monster.getPosition());

        monsterController.tick(new Position(5, 1));
        Assertions.assertEquals(new Position(5, 3), monster.getPosition());
    }

    @Test
    public void moveMonsterToTargetBelow() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(new Position(10, 10));
        Assertions.assertEquals(new Position(6, 7), monster.getPosition());

        monsterController.tick(new Position(1, 10));
        Assertions.assertEquals(new Position(5, 8), monster.getPosition());

        monsterController.tick(new Position(5, 10));
        Assertions.assertEquals(new Position(5, 9), monster.getPosition());
    }

    @Test
    public void moveMonsterSamePosition() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(new Position(5, 6));
        Assertions.assertEquals(new Position(5, 6), monster.getPosition());
    }

    @Test
    public void moveMonsterInvalidPosition() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        monsterController.tick(new Position(-1, 0));
                    }
                });
    }
}
