package g0803.bindingofshiba.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.gui.keyboard.LanternaKeyboard;

import java.io.IOException;

public class LanternaGUI implements GUI {

    private final Screen screen;
    private final Keyboard keyboard;

    public LanternaGUI(int width, int height) throws IOException {
        TerminalSize screenSize = new TerminalSize(width, height);
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(screenSize)
                .createTerminal();

        this.screen = new TerminalScreen(terminal);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();

        this.keyboard = new LanternaKeyboard(this.screen);
    }

    public LanternaGUI(Screen screen) {
        this.screen = screen;
        this.keyboard = new LanternaKeyboard(screen);
    }

    @Override
    public void close() throws IOException {
        this.screen.close();
    }

    @Override
    public void clear() {
        this.screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        this.screen.refresh();
    }

    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }
}
