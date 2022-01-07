package g0803.bindingofshiba;

import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.state.State;

public interface App {
    void setState(State<?> state);

    Keyboard getKeyboard();
}
