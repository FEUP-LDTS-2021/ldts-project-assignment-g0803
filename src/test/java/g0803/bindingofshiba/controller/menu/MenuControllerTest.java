package g0803.bindingofshiba.controller.menu;

import g0803.bindingofshiba.gui.keyboard.Keyboard;
import g0803.bindingofshiba.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class MenuControllerTest {

    public Menu getMenu() {
        List<String> options = Arrays.asList("Resume", "Exit");
        return new Menu("Menu 1", options);
    }

    @Test
    void changeBetweenOptions() {
        Menu menu = getMenu();
        Keyboard keyboard = Mockito.mock(Keyboard.class);
        MenuController controller = new MenuController(menu, keyboard);

        // Simulate DOWN Arrow key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.ARROW_DOWN)).thenReturn(true);
        controller.changeOption();

        Assertions.assertEquals(1, menu.getChoice());

        Mockito.reset(keyboard);

        // Simulate UP Arrow key press
        Mockito.when(keyboard.isKeyPressed(Keyboard.Key.ARROW_UP)).thenReturn(true);
        controller.changeOption();

        Assertions.assertEquals(0, menu.getChoice());
    }

}
