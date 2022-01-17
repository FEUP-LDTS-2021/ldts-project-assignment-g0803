package g0803.bindingofshiba.model.game;

import g0803.bindingofshiba.math.Vec2D;

public class Door {

    public Vec2D getPositionByWall(Room room) {
        throw new RuntimeException("Not implemented");
    }

    public Door(Room origin, DoorPosition originPosition, Room destination, DoorPosition destinationPosition) {
        throw new RuntimeException("Not implemented");
    }

    public Room getOriginRoom() {
        throw new RuntimeException("Not implemented");
    }

    public DoorPosition getOriginPosition() {
        throw new RuntimeException("Not implemented");
    }

    public DoorPosition getDestinationPosition() {
        throw new RuntimeException("Not implemented");
    }

    public Room getDestinationRoom() {
        throw new RuntimeException("Not implemented");
    }

    public boolean getUnlocked() {
        throw new RuntimeException("Not implemented");
    }

    public void unlock() {
        throw new RuntimeException("Not implemented");
    }
}
