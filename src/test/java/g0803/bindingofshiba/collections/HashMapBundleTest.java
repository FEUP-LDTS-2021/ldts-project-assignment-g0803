package g0803.bindingofshiba.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class HashMapBundleTest {

    @Test
    public void entryIsRegistered() {
        HashMapBundle<Color> colors = new HashMapBundle<>();

        colors.register("red", Color.red);
        Assertions.assertEquals(Color.red, colors.get("red"));
    }

    @Test
    public void entryIsNotRegistered() {
        HashMapBundle<Color> colors = new HashMapBundle<>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> colors.get("blue"));
    }

    @Test
    public void multipleEntriesAreRegistered() {
        HashMapBundle<Color> colors = new HashMapBundle<>();

        colors.register("red", Color.red);
        colors.register("blue", Color.blue);
        Assertions.assertEquals(Color.red, colors.get("red"));
        Assertions.assertEquals(Color.blue, colors.get("blue"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> colors.get("brown"));
    }
}
