package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.model.game.Monster;
import g0803.bindingofshiba.model.game.Position;

public class MonsterController {
    private Monster monster;

    public MonsterController(Monster monster) {
        this.monster = monster;
    }

    private void moveToTarget(Position target) {
        if (target.getX() < 0 || target.getY() < 0) {
            throw new IllegalArgumentException("Invalid position");
        }

        int newX = monster.getPosition().getX(), newY = monster.getPosition().getY();
        if (target.getX() > monster.getPosition().getX()) {
            newX++;
        } else if (target.getX() < monster.getPosition().getX()) {
            newX--;
        }

        if (target.getY() > monster.getPosition().getY()) {
            newY++;
        } else if (target.getY() < monster.getPosition().getY()) {
            newY--;
        }

        monster.setPosition(new Position(newX, newY));

    }

    private void takeDamage(int damage) {
        this.monster.decreaseHpByAmount(damage);
    }

    public void tick(Position position) {
        moveToTarget(position);
    }

}
