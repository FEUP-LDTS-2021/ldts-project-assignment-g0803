package g0803.bindingofshiba;

import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.bundles.DefaultFontsProvider;
import g0803.bindingofshiba.bundles.DefaultTexturesProvider;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.gui.LanternaGUI;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.state.State;
import g0803.bindingofshiba.state.game.GameState;
import g0803.bindingofshiba.textures.ITexture;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main implements App {

    private State<?> state;
    private final GUI gui;

    private final Bundle<Font> fonts;
    private final Bundle<ITexture> textures;

    public Main() throws IOException, FontFormatException {
        this.fonts = new DefaultFontsProvider().getBundle();
        this.textures = new DefaultTexturesProvider().getBundle();

        this.state = new GameState(new Game());
        this.gui = new LanternaGUI(fonts, Constants.WIDTH, Constants.HEIGHT);
    }

    public Main(State<?> initialState, GUI gui, Bundle<Font> fonts, Bundle<ITexture> textures) {
        this.fonts = fonts;
        this.textures = textures;

        this.state = initialState;
        this.gui = gui;
    }

    public static void main(String[] args)
            throws IOException, URISyntaxException, FontFormatException {
        new Main().start();
    }

    @Override
    public void setState(State<?> state) {
        this.state = state;
    }

    @Override
    public Keyboard getKeyboard() {
        return this.gui.getKeyboard();
    }

    @Override
    public Bundle<Font> getFonts() {
        return fonts;
    }

    @Override
    public Bundle<ITexture> getTextures() {
        return textures;
    }

    public void start() throws IOException {
        int frameTime = 1000 / Constants.FPS;

        Keyboard keyboard = this.gui.getKeyboard();

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            keyboard.update();
            if (keyboard.isClosed()) break;

            this.state.step(this, this.gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException ignored) {
                break;
            }
        }

        this.gui.close();
    }
}
