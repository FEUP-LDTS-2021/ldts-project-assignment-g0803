package g0803.bindingofshiba.controller.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.Position;

import java.io.IOException;

public class MonsterController extends Controller<Monster> {

    public MonsterController(Monster model) {
        super(model);
    }

    private void moveToTarget(Position target) {
        if (target.getX() < 0 || target.getY() < 0)
            throw new IllegalArgumentException("Invalid position");

        Position monsterPos = this.getModel().getPosition();
        int newX = monsterPos.getX(), newY = monsterPos.getY();

        if (target.getX() > this.getModel().getPosition().getX()) {
            newX++;
        } else if (target.getX() < monsterPos.getX()) {
            newX--;
        }

        if (target.getY() > monsterPos.getY()) {
            newY++;
        } else if (target.getY() < monsterPos.getY()) {
            newY--;
        }

        this.getModel().setPosition(new Position(newX, newY));
    }

    private void takeDamage(int damage) {
        this.getModel().decreaseHpByAmount(damage);
    }

    public void tick(Position position) {
        moveToTarget(position);
    }

    @Override
    public void tick(App app) throws IOException {}
}
