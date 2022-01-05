package g0803.bindingofshiba.view.game;

import com.googlecode.lanterna.TextColor;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.Monster;

public class MonsterView {
    private Monster monster;

    public MonsterView(Monster monster) {
        this.monster = monster;
    }

    public void draw(GUI gui) {
        TextColor foregroundColor = TextColor.Factory.fromString("#FF00FF");
        TextColor backgroundColor = TextColor.Factory.fromString("#444444");

        gui.drawText(
                monster.getPosition().getX(),
                monster.getPosition().getY(),
                "M",
                foregroundColor,
                backgroundColor);
    }
}
