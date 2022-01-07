package g0803.bindingofshiba;

import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.state.State;

public class Main implements App {

    private State<?> state;
    private final GUI gui;

    public Main(State<?> initialState, GUI gui) {
        this.state = initialState;
        this.gui = gui;
    }

    @Override
    public void setState(State<?> state) {
        this.state = state;
    }

    @Override
    public Keyboard getKeyboard() {
        return this.gui.getKeyboard();
    }
}
