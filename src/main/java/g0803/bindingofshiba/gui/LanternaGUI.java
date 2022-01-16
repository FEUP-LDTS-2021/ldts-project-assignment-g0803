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
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.textures.ITexture;
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
    public void blit(int x, int y, ITexture texture) {
        TextGraphics textGraphics = this.screen.newTextGraphics();

        Vec2D offset = texture.getAnchorOffset(x, y);
        for (int i = 0; i < texture.getWidth(); i++) {
            for (int j = 0; j < texture.getHeight(); j++) {
                Color color = texture.getColorAt(i, j);
                if (color == null || color.getAlpha() < 128) continue;

                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                Vec2D position = new Vec2D(i, j).add(offset);
                int realX = (int) position.getX();
                int realY = (int) position.getY();

                textGraphics.setBackgroundColor(new TextColor.RGB(red, green, blue));
                textGraphics.setCharacter(realX, realY, ' ');
            }
        }
    }

    @Override
    public void fill(Color color) {
        if (color == null || color.getAlpha() < 128)
            return;

        TextGraphics textGraphics = this.screen.newTextGraphics();

        TextColor textColor = new TextColor.RGB(color.getRed(), color.getGreen(), color.getBlue());
        textGraphics.setBackgroundColor(textColor);
        textGraphics.fill(' ');
    }

    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }
}
