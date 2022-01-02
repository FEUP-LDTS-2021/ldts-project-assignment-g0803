package g0803.bindingofshiba.gui;

import g0803.bindingofshiba.gui.keyboard.Keyboard;

import java.io.IOException;

public interface GUI {

    Keyboard getKeyboard();
    void close() throws IOException;
    void clear();
    void refresh() throws IOException;
}
