package g0803.bindingofshiba.controller.menu;

import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.model.menu.Menu;

public class MenuController {
    private Menu menu;
    private Keyboard keyboard;

    public MenuController(Menu menu, Keyboard keyboard) {
        this.menu = menu;
        this.keyboard = keyboard;
    }

    public void changeOption() {
        if (keyboard.isKeyPressed(Keyboard.Key.ARROW_UP)) {
            menu.getPreviousOption();
        } else if (keyboard.isKeyPressed(Keyboard.Key.ARROW_DOWN)) {
            menu.getNextOption();
        }
    }

}
