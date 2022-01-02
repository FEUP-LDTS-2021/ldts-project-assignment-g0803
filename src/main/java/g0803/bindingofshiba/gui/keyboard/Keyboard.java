package g0803.bindingofshiba.gui.keyboard;

import java.io.IOException;

public interface Keyboard {

    enum Key {
        W, A, S, D,
        ARROW_UP, ARROW_DOWN, ARROW_LEFT, ARROW_RIGHT,
        SPACE, ENTER, ESCAPE;
    }

    boolean isKeyPressed(Key key);
    long getKeyPressDuration();
    boolean isClosed();

    void update() throws IOException;
}
