package g0803.bindingofshiba.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI implements GUI {

    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException {
        TerminalSize screenSize = new TerminalSize(width, height);
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(screenSize)
                .createTerminal();

        this.screen = new TerminalScreen(terminal);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();
    }

    public LanternaGUI(Screen screen) {
        this.screen = screen;
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
        this.screen.clear();
    }

    @Override
    public void drawText(int x, int y, String text, TextColor foregroundColor, TextColor backgroundColor) {

    }
}
