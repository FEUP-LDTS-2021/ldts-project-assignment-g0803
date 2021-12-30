package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.model.game.Monster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MonsterControllerTest {
    public MonsterController monsterController= new MonsterController();
    public Monster getMonster() {
        return new Monster(5, 6, 50, 20);
    }

    @Test
    public void move_monster_to_target_ahead() {
        Monster monster = getMonster();

        monsterController.moveToTarget(monster, 10, 10);
        Assertions.assertEquals(6, monster.getX());
        Assertions.assertEquals(7, monster.getY());

        monsterController.moveToTarget(monster, 10, 1);
        Assertions.assertEquals(7, monster.getX());
        Assertions.assertEquals(6, monster.getY());

        monsterController.moveToTarget(monster, 10, 6);
        Assertions.assertEquals(8, monster.getX());
        Assertions.assertEquals(6, monster.getY());
    }

    @Test
    public void move_monster_to_target_behind() {
        Monster monster = getMonster();

        monsterController.moveToTarget(monster, 1, 1);
        Assertions.assertEquals(4, monster.getX());
        Assertions.assertEquals(5, monster.getY());

        monsterController.moveToTarget(monster, 1, 10);
        Assertions.assertEquals(3, monster.getX());
        Assertions.assertEquals(6, monster.getY());

        monsterController.moveToTarget(monster, 1, 6);
        Assertions.assertEquals(2, monster.getX());
        Assertions.assertEquals(6, monster.getY());
    }

    @Test
    public void move_monster_to_target_above() {
        Monster monster = getMonster();

        monsterController.moveToTarget(monster, 10, 1);
        Assertions.assertEquals(6, monster.getX());
        Assertions.assertEquals(5, monster.getY());

        monsterController.moveToTarget(monster, 1, 1);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(4, monster.getY());

        monsterController.moveToTarget(monster, 5, 1);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(3, monster.getY());
    }

    @Test
    public void move_monster_to_target_below() {
        Monster monster = getMonster();

        monsterController.moveToTarget(monster, 10, 10);
        Assertions.assertEquals(6, monster.getX());
        Assertions.assertEquals(7, monster.getY());

        monsterController.moveToTarget(monster, 1, 10);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(8, monster.getY());

        monsterController.moveToTarget(monster, 5, 10);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(9, monster.getY());
    }

    @Test
    public void move_monster_same_position() {
        Monster monster = getMonster();

        monsterController.moveToTarget(monster, 5, 5);
        Assertions.assertEquals(5, monster.getX());
        Assertions.assertEquals(5, monster.getY());
    }

    @Test
    public void move_monster_invalid_position() {
        Monster monster = getMonster();

        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                monsterController.moveToTarget(monster, -1, 0);
            }
        });
    }

    @Test
    public void get_hit() {
        Monster monster = getMonster();

        monsterController.takeDamage(monster, 10);
        Assertions.assertEquals(40, monster.getHp());

        monsterController.takeDamage(monster, 20);
        Assertions.assertEquals(20, monster.getHp());
    }

}
