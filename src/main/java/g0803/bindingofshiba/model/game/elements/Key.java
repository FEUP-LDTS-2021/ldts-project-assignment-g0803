package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.model.game.Position;

public class Key extends Element {
    Boolean isPickedUp = false;

    public Key(Position position) {
        super(position);
    }

    public Key(int x, int y) {
        super(x, y);
    }

    public boolean isPickedUp() {
        return this.isPickedUp;
    }

    public void pickUp() {
        this.isPickedUp = true;
    }
}
