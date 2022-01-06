package g0803.bindingofshiba.view.menu;

import g0803.bindingofshiba.model.game.Position;
import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.menu.Menu;

public class MenuView {
    private Menu menu;

    public MenuView(Menu menu) {
        this.menu = menu;
    }

    public void draw(GUI gui) {
        TextColor foregroundColor = TextColor.Factory.fromString("#DAE3EA");
        TextColor backgroundColor = TextColor.Factory.fromString("#034270");

        gui.drawText(20, 2, menu.getTitle(), foregroundColor, backgroundColor);

        Position firstPosition = new Position(4,4);
        for (int i = 0; i < menu.getOptions().size(); i++) {
            gui.drawText(firstPosition.getX(), firstPosition.getY(), "[" + Integer.toString(i+1) + "]" + menu.getOptions().get(i), foregroundColor, backgroundColor);
            firstPosition = new Position(firstPosition.getX(), firstPosition.getY() + 2);
        }

    }
}
