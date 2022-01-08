package g0803.bindingofshiba.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import g0803.bindingofshiba.Constants;
import g0803.bindingofshiba.gui.fonts.Fonts;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.gui.keyboard.LanternaKeyboard;
import java.awt.*;
import java.io.IOException;

public class LanternaGUI implements GUI {

    private final Screen screen;
    private final Keyboard keyboard;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException {
        SwingTerminalFontConfiguration squareFontConfig =
                Fonts.loadFontConfiguration(
                        Constants.SQUARE_FONT_LOCATION, Constants.SQUARE_FONT_SIZE);
        Terminal terminal = createTerminal(squareFontConfig, width, height);

        this.screen = new TerminalScreen(terminal);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();

        this.keyboard = new LanternaKeyboard(this.screen);
    }

    public LanternaGUI(Screen screen) {
        this.screen = screen;
        this.keyboard = new LanternaKeyboard(screen);
    }

    private Terminal createTerminal(
            SwingTerminalFontConfiguration fontConfig, int width, int height) throws IOException {
        TerminalSize screenSize = new TerminalSize(width, height);
        return new DefaultTerminalFactory()
                .setInitialTerminalSize(screenSize)
                .setPreferTerminalEmulator(true)
                .setTerminalEmulatorFontConfiguration(fontConfig)
                .createTerminal();
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
    public void drawText(
            int x, int y, String text, TextColor foregroundColor, TextColor backgroundColor) {
        TextGraphics textGraphics = this.screen.newTextGraphics();
        textGraphics.setForegroundColor(foregroundColor);
        textGraphics.setBackgroundColor(backgroundColor);
        textGraphics.putString(x, y, text);
    }

    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }
}
