package g0803.bindingofshiba;

import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.state.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MainTest {

    @Test
    public void returnsCorrectKeyboard() throws IOException {
        Keyboard keyboard = Mockito.mock(Keyboard.class);
        GUI gui = Mockito.mock(GUI.class);

        Mockito.when(gui.getKeyboard()).thenReturn(keyboard);

        State<?> mockState = Mockito.mock(State.class);

        App main = new Main(mockState, gui, null, null);
        Assertions.assertEquals(keyboard, main.getKeyboard());
    }
}
