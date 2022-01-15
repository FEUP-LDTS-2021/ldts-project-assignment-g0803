package g0803.bindingofshiba.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LanternaGUITest {

    @Test
    public void closesScreen() throws IOException {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        gui.close();

        Mockito.verify(screen, Mockito.only()).close();
    }

    @Test
    public void refreshesScreen() throws IOException {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        gui.refresh();

        Mockito.verify(screen, Mockito.only()).refresh();
    }

    @Test
    public void clearsScreen() throws IOException {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        gui.clear();

        Mockito.verify(screen, Mockito.only()).clear();
    }
}
