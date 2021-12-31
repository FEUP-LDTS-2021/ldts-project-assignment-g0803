package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.model.game.Monster;

public class MonsterController {
    private Monster monster;

    public MonsterController(Monster monster) {
        this.monster = monster;
    }

    private void moveToTarget(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (x > monster.getX()) {
            monster.setX(monster.getX() + 1);
        } else if (x < monster.getX()) {
            monster.setX(monster.getX() - 1);
        }

        if (y > monster.getY()) {
            monster.setY(monster.getY() + 1);
        } else if (y < monster.getY()) {
            monster.setY(monster.getY() - 1);
        }
    }

    private void takeDamage(int damage) {
        this.monster.decreaseHpByAmount(damage);
    }

    public void tick(int x, int y) {
        moveToTarget(x, y);
    }

}
