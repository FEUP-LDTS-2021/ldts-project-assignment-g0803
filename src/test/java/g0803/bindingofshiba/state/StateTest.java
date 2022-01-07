package g0803.bindingofshiba.state;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.view.View;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class StateTest {

    @Test
    @SuppressWarnings("rawtypes")
    public void step() throws IOException {
        View<?> view = Mockito.mock(View.class);
        Controller<?> controller = Mockito.mock(Controller.class);

        App app = Mockito.mock(App.class);
        GUI gui = Mockito.mock(GUI.class);

        State<?> state = new State("Hello", controller, view);
        state.step(app, gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
        Mockito.verify(view, Mockito.times(1)).draw(gui);
        Mockito.verify(controller, Mockito.times(1)).tick(app);
    }
}
