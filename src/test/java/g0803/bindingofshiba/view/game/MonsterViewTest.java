package g0803.bindingofshiba.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.gui.LanternaGUI;
import g0803.bindingofshiba.model.game.Monster;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterViewTest {

    @Test
    public void drawMonster() {
        Monster monster = new Monster(5,5, 10, 50);
        MonsterView view = new MonsterView(monster);

        GUI gui = Mockito.mock(GUI.class);

        view.draw(gui);

        TextColor foregroundColor = TextColor.Factory.fromString("#FF00FF");
        TextColor backgroundColor = TextColor.Factory.fromString("#444444");

        Mockito.verify(gui, Mockito.times(1)).drawText(5, 5, "M", foregroundColor, backgroundColor);
    }
}
