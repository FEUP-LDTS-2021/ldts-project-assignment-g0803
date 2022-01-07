package g0803.bindingofshiba;

import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.gui.LanternaGUI;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.state.State;
import g0803.bindingofshiba.state.game.GameState;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main implements App {

    private State<?> state;
    private final GUI gui;

    public Main() throws IOException, FontFormatException {
        this(new GameState(new Game()), new LanternaGUI(150, 75));
    }

    public Main(State<?> initialState, GUI gui) {
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
