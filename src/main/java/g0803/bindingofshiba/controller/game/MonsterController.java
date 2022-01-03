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

        int new_x = monster.getPosition().getX(), new_y = monster.getPosition().getY();
        if (target.getX() > monster.getPosition().getX()) {
            new_x++;
        } else if (target.getX() < monster.getPosition().getX()) {
            new_x--;
        }

        if (target.getY() > monster.getPosition().getY()) {
            new_y++;
        } else if (target.getY() < monster.getPosition().getY()) {
            new_y--;
        }

        monster.setPosition(new Position(new_x, new_y));

    }

    private void takeDamage(int damage) {
        this.monster.decreaseHpByAmount(damage);
    }

    public void tick(Position position) {
        moveToTarget(position);
    }

}
