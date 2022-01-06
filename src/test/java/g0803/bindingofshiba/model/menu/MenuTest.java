package g0803.bindingofshiba.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuTest {

    @Test
    public void addOptionMenuEmpty() {
        List<String> options = new ArrayList<>();
        Menu menu = new Menu("BINDING OF SHIBA", options);

        menu.addOption("Play");
        menu.addOption("Save");

        List<String> list = Arrays.asList("Play", "Save");
        Assertions.assertEquals(list, menu.getOptions());
    }

    @Test
    public void addOption() {
        List<String> options = Arrays.asList("Play", "Save");
        Menu menu = new Menu("BINDING OF SHIBA", options);

        menu.addOption("Exit");
        menu.addOption("Another Option");

        List<String> list = Arrays.asList("Play", "Save", "Exit", "Another Option");
        Assertions.assertEquals(list, menu.getOptions());
    }

    @Test
    public void isSelectedLast() {
        List<String> options = Arrays.asList("Resume", "Restart", "Exit");
        Menu menu = new Menu("Menu 1", options);

        menu.getNextOption();
        menu.getNextOption();

        Assertions.assertEquals(2, menu.getChoice());
    }

    @Test
    public void isSelectedFirstNoChanges() {
        List<String> options = Arrays.asList("Resume", "Restart", "Exit");
        Menu menu = new Menu("Menu 2", options);

        Assertions.assertEquals(0, menu.getChoice());
    }

    @Test
    public void isSelectedFirstWithInput() {
        List<String> options = Arrays.asList("Option 1", "option 2", "Option 3", "Option 4");
        Menu menu = new Menu("Menu", options);

        menu.getNextOption();
        menu.getPreviousOption();
        menu.getNextOption();
        menu.getNextOption();
        menu.getPreviousOption();
        menu.getNextOption();
        menu.getPreviousOption();
        menu.getPreviousOption();

        Assertions.assertEquals(0, menu.getChoice());
    }

    @Test
    public void tryToSelectBefore() {
        List<String> options = Arrays.asList("Resume", "Restart", "Exit");
        Menu menu = new Menu("Title", options);

        menu.getPreviousOption();

        Assertions.assertEquals(0, menu.getChoice());
    }

    @Test
    public void tryToSelectBeyond() {
        List<String> options = Arrays.asList("Resume", "Restart", "Exit");
        Menu menu = new Menu("Menu", options);

        menu.getNextOption();
        menu.getNextOption();
        menu.getNextOption();
        menu.getNextOption();

        Assertions.assertEquals(2, menu.getChoice());
    }

}
