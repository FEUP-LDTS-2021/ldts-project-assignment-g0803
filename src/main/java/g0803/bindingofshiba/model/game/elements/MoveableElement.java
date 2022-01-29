package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.math.Vec2D;

public class MoveableElement extends Element {

    private Vec2D velocity = Vec2D.zero();
    private Vec2D acceleration = Vec2D.zero();

    public MoveableElement(Vec2D position) {
        super(position);
    }

    public Vec2D getVelocity() {
        return velocity;
    }

    public Vec2D getAcceleration() {
        return acceleration;
    }

    public void setVelocity(Vec2D velocity) {
        this.velocity = velocity;
    }

    public void setAcceleration(Vec2D acceleration) {
        this.acceleration = acceleration;
    }

    public Vec2D getNextVelocity(double dt) {
        throw new RuntimeException("Not implemented");
    }

    public Vec2D getNextPosition(double dt) {
        throw new RuntimeException("Not implemented");
    }

    public void move(double dt) {
        Vec2D nextVelocity = this.velocity.add(this.acceleration.scale(dt));
        Vec2D nextPosition = this.getPosition().add(nextVelocity.scale(dt));

        this.setVelocity(nextVelocity);
        this.setPosition(nextPosition);
    }
}
