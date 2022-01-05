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

    @Test
    public void drawText() {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        TextColor foregroundColor = TextColor.Factory.fromString("#FFFF00");
        TextColor backgroundColor = TextColor.Factory.fromString("#123456");

        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui.drawText(5, 10, "We miss LPOO", foregroundColor, backgroundColor);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(foregroundColor);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(backgroundColor);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(5, 10, "We miss LPOO");
    }

    @Test
    public void draw_text() {
        Screen screen = Mockito.mock(Screen.class);

        GUI gui = new LanternaGUI(screen);
        TextColor foregroundColor = TextColor.Factory.fromString("#FFFF00");
        TextColor backgroundColor = TextColor.Factory.fromString("#123456");

        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui.drawText(5, 10, "We miss LPOO", foregroundColor, backgroundColor);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(foregroundColor);
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(backgroundColor);
        Mockito.verify(textGraphics, Mockito.times(1)).putString(5, 10, "We miss LPOO");
    }
}
