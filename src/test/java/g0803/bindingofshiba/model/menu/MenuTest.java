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
}
