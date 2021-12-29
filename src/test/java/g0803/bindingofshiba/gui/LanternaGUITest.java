package g0803.bindingofshiba.gui;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {

    @Test
    public void closes_screen() throws IOException {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        gui.close();

        Mockito.verify(screen).close();
    }

    @Test
    public void refreshes_screen() throws IOException {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        //gui.refresh();

        Mockito.verify(screen).refresh();
    }

    @Test
    public void clears_screen() throws IOException {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        gui.clear();

        Mockito.verify(screen).clear();
    }
}
