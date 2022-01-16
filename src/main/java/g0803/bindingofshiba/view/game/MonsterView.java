package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.view.View;

public class MonsterView extends View<Monster> {

    public MonsterView(Monster model) {
        super(model);
    }

    @Override
    public void draw(App app, GUI gui) {
        throw new RuntimeException("Not implemented");
    }
}
