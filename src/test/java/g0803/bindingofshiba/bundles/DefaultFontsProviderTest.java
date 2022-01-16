package g0803.bindingofshiba.bundles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import java.awt.*;
import java.io.IOException;
import java.util.Set;

public class DefaultFontsProviderTest {

    @Test
    public void hasRequiredKeys() throws IOException, FontFormatException {
        Bundle<Font> bundle = new DefaultFontsProvider().getBundle();

        Set<String> expected = Sets.newSet("square", "text");
        Set<String> actual = bundle.keys();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void hasDefaultFonts() throws IOException, FontFormatException {
        Bundle<Font> bundle = new DefaultFontsProvider().getBundle();

        Font squareFont = bundle.get("square");
        Assertions.assertEquals("Square", squareFont.getFontName());

        Font textFont = bundle.get("text");
        Assertions.assertEquals("CG pixel 4x5 Regular", textFont.getFontName());
    }
}
