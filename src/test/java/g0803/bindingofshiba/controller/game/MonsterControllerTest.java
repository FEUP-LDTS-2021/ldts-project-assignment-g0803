package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.model.game.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MonsterControllerTest {
    public Monster getMonster() {
        return new Monster(5, 6, 50, 20);
    }

    @Test
    public void moveMonsterToTargetAhead() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(10, 10);
        Assertions.assertEquals(6, monster.getX());
        Assertions.assertEquals(7, monster.getY());

        monsterController.tick(10, 1);
        Assertions.assertEquals(7, monster.getX());
        Assertions.assertEquals(6, monster.getY());

        monsterController.tick(10, 6);
        Assertions.assertEquals(8, monster.getX());
        Assertions.assertEquals(6, monster.getY());
    }

    @Test
    public void moveMonsterToTargetBehind() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(1, 1);
        Assertions.assertEquals(4, monster.getX());
        Assertions.assertEquals(5, monster.getY());

        monsterController.tick(1, 10);
        Assertions.assertEquals(3, monster.getX());
        Assertions.assertEquals(6, monster.getY());

        monsterController.tick(1, 6);
        Assertions.assertEquals(2, monster.getX());
        Assertions.assertEquals(6, monster.getY());
    }

    @Test
    public void moveMonsterToTargetAbove() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(10, 1);
        Assertions.assertEquals(6, monster.getX());
        Assertions.assertEquals(5, monster.getY());

        monsterController.tick(1, 1);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(4, monster.getY());

        monsterController.tick(5, 1);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(3, monster.getY());
    }

    @Test
    public void moveMonsterToTargetBelow() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(10, 10);
        Assertions.assertEquals(6, monster.getX());
        Assertions.assertEquals(7, monster.getY());

        monsterController.tick(1, 10);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(8, monster.getY());

        monsterController.tick(5, 10);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(9, monster.getY());
    }

    @Test
    public void moveMonsterSamePosition() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        monsterController.tick(5, 5);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(5, monster.getY());
    }

    @Test
    public void moveMonsterInvalidPosition() {
        Monster monster = getMonster();
        MonsterController monsterController = new MonsterController(monster);

        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                monsterController.tick(-1, 0);
            }
        });
    }

    /*
    @Test
    public void getHit() {
        Monster monster = getMonster();

        monsterController.takeDamage(monster, 10);
        Assertions.assertEquals(40, monster.getHp());

        monsterController.takeDamage(monster, 20);
        Assertions.assertEquals(20, monster.getHp());
    }
    */

}
