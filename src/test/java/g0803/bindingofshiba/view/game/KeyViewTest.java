package g0803.bindingofshiba.view.game;

import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.Position;
import g0803.bindingofshiba.model.game.elements.Key;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class KeyViewTest {

    @Test
    public void drawKey() {
        Key key = new Key(new Position(6, 6));
        KeyView view = new KeyView(key);

        GUI gui = Mockito.mock(GUI.class);

        view.draw(gui);

        TextColor foregroundColor = TextColor.Factory.fromString("#23EFC6");
        TextColor backgroundColor = TextColor.Factory.fromString("#333333");

        Mockito.verify(gui, Mockito.times(1)).drawText(6, 6, "F", foregroundColor, backgroundColor);
    }
}
