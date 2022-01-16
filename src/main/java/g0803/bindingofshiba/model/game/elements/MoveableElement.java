package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.math.Vec2D;

public class MoveableElement extends Element {

    public MoveableElement(Vec2D position) {
        super(position);
        throw new RuntimeException("Not implemented");
    }

    public Vec2D getVelocity() {
        throw new RuntimeException("Not implemented");
    }

    public Vec2D getAcceleration() {
        throw new RuntimeException("Not implemented");
    }

    public void setVelocity(Vec2D velocity) {
        throw new RuntimeException("Not implemented");
    }

    public void setAcceleration(Vec2D acceleration) {
        throw new RuntimeException("Not implemented");
    }

    public void move(double dt) {
        throw new RuntimeException("Not implemented");
    }
}
