package g0803.bindingofshiba.view.game;

import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterViewTest {

    @Test
    public void drawMonster() {
        Monster monster = new Monster(new Position(5, 5), 10, 50);
        MonsterView view = new MonsterView(monster);

        GUI gui = Mockito.mock(GUI.class);

        view.draw(gui);

        TextColor foregroundColor = TextColor.Factory.fromString("#FF00FF");
        TextColor backgroundColor = TextColor.Factory.fromString("#444444");

        Mockito.verify(gui, Mockito.times(1)).drawText(5, 5, "M", foregroundColor, backgroundColor);
    }
}
