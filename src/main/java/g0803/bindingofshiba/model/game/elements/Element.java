package g0803.bindingofshiba.model.game.elements;

import g0803.bindingofshiba.model.game.Position;

public class Element {
    private Position position;

    public Element(Position position) {
        this.position = position;
    }

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
