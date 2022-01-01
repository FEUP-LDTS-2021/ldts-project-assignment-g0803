package g0803.bindingofshiba.gui.keyboard;

import com.googlecode.lanterna.input.InputProvider;

public class LanternaKeyboard implements Keyboard {

    public LanternaKeyboard(InputProvider inputProvider) {}

    @Override
    public boolean isKeyPressed(Key key) {
        return false;
    }

    @Override
    public long getKeyPressDuration() {
        return -1;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public void update() {}
}
