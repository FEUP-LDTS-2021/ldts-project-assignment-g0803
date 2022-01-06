package g0803.bindingofshiba.view.menu;

import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.Position;
import g0803.bindingofshiba.model.menu.Menu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class MenuViewTest {

    @Test
    public void drawMenu() {
        List<String> options = Arrays.asList("Play", "Save", "Exit");
        Menu menu = new Menu("BINDING OF SHIBA", options);
        MenuView view = new MenuView(menu);

        GUI gui = Mockito.mock(GUI.class);

        view.draw(gui);

        TextColor foregroundColor = TextColor.Factory.fromString("#DAE3EA");
        TextColor backgroundColor = TextColor.Factory.fromString("#034270");

        Position firstPosition = new Position(4, 4);

        Mockito.verify(gui, Mockito.times(1)).drawText(20, 2, menu.getTitle(), foregroundColor, backgroundColor);

        for (int i = 0; i < menu.getOptions().size(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(firstPosition.getX(), firstPosition.getY(), "["+ Integer.toString(i+1) + "]" + menu.getOptions().get(i), foregroundColor, backgroundColor);
            firstPosition = new Position(firstPosition.getX(), firstPosition.getY() + 2);
        }
    }
}
