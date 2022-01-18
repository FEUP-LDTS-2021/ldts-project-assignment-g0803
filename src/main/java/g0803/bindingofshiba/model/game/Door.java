package g0803.bindingofshiba.model.game;

import g0803.bindingofshiba.math.Vec2D;

public class Door {

    private Room originRoom;
    private Room destinationRoom;
    private DoorPosition originPosition;
    private DoorPosition destinationPosition;
    private boolean isUnlocked = false;

    public Vec2D getPositionByWall(Room room) {
        if (room != originRoom && room != destinationRoom) {
            throw new IllegalArgumentException("Room is not origin nor destination");
        }
        if (room == originRoom) {
            return switch (originPosition) {
                case TOP -> new Vec2D(room.getWidth()/2, 0);
                case BOTTOM -> new Vec2D(room.getWidth()/2, room.getHeight());
                case RIGHT -> new Vec2D(room.getWidth(), room.getHeight()/2);
                case LEFT -> new Vec2D(0, room.getHeight()/2);
            };

        } else {
            return switch (destinationPosition) {
                case BOTTOM -> new Vec2D(room.getWidth() / 2, room.getHeight());
                case TOP -> new Vec2D(room.getWidth() / 2, 0);
                case LEFT -> new Vec2D(0, room.getHeight() / 2);
                case RIGHT -> new Vec2D(room.getWidth(), room.getHeight() / 2);
            };
        }
    }

    public Door(Room origin, DoorPosition originPosition, Room destination, DoorPosition destinationPosition) {
        this.originRoom = origin;
        this.originPosition = originPosition;
        this.destinationRoom = destination;
        this.destinationPosition = destinationPosition;

    }

    public Room getOriginRoom() {
        return this.originRoom;
    }

    public DoorPosition getOriginPosition() {
            return this.originPosition;
    }

    public DoorPosition getDestinationPosition() {
        return this.destinationPosition;
    }

    public Room getDestinationRoom() {
        return this.destinationRoom;
    }

    public boolean getUnlocked() {
        return this.isUnlocked;
    }

    public void unlock() {
        this.isUnlocked = true;
    }
}
