package g0803.bindingofshiba.gui;

import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class LanternaGUI implements GUI {

    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void clear() {

    }

    @Override
    public void refresh() throws IOException {

    }
}
