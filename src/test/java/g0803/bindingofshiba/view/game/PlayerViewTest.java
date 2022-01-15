package g0803.bindingofshiba.view.game;

import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.Position;
import g0803.bindingofshiba.model.game.elements.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlayerViewTest {
    public Player getPlayer() {
        return new Player(new Position(5, 5), 0, 50, 20);
    }
}
