package g0803.bindingofshiba.textures;

import g0803.bindingofshiba.math.Vec2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TextBuilderTest {

    private static Font pixelFont;

    @BeforeAll
    public static void setup() throws IOException, FontFormatException {
        Font font = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(
                TextBuilderTest.class.getResourceAsStream("/cg-pixel-4x5.ttf")
        ));

        TextBuilderTest.pixelFont = font.deriveFont(Font.PLAIN, 5);
    }

    @Test
    public void setText() {
        StaticTexture.TextBuilder builder = new StaticTexture.TextBuilder(pixelFont).setText("A");
        StaticTexture texture = builder.build();

        Assertions.assertEquals(Color.white, texture.getColorAt(1, 0));
        Assertions.assertEquals(Color.white, texture.getColorAt(2, 0));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 1));
        Assertions.assertEquals(Color.white, texture.getColorAt(3, 1));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 2));
        Assertions.assertEquals(Color.white, texture.getColorAt(1, 2));
        Assertions.assertEquals(Color.white, texture.getColorAt(2, 2));
        Assertions.assertEquals(Color.white, texture.getColorAt(3, 2));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 3));
        Assertions.assertEquals(Color.white, texture.getColorAt(3, 3));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 4));
        Assertions.assertEquals(Color.white, texture.getColorAt(3, 4));

        Color transparent = new Color(0, 0, 0, 0);
        Assertions.assertEquals(transparent, texture.getColorAt(0, 0));
        Assertions.assertEquals(transparent, texture.getColorAt(3, 0));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 1));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 1));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 3));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 3));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 4));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 4));
    }

    @Test
    public void worksWithOtherCharacters() {
        StaticTexture.TextBuilder builder = new StaticTexture.TextBuilder(pixelFont).setText("B");
        StaticTexture texture = builder.build();

        Assertions.assertEquals(Color.white, texture.getColorAt(0, 0));
        Assertions.assertEquals(Color.white, texture.getColorAt(1, 0));
        Assertions.assertEquals(Color.white, texture.getColorAt(2, 0));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 1));
        Assertions.assertEquals(Color.white, texture.getColorAt(3, 1));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 2));
        Assertions.assertEquals(Color.white, texture.getColorAt(1, 2));
        Assertions.assertEquals(Color.white, texture.getColorAt(2, 2));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 3));
        Assertions.assertEquals(Color.white, texture.getColorAt(3, 3));
        Assertions.assertEquals(Color.white, texture.getColorAt(0, 4));
        Assertions.assertEquals(Color.white, texture.getColorAt(1, 4));
        Assertions.assertEquals(Color.white, texture.getColorAt(2, 4));

        Color transparent = new Color(0, 0, 0, 0);
        Assertions.assertEquals(transparent, texture.getColorAt(3, 0));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 1));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 1));
        Assertions.assertEquals(transparent, texture.getColorAt(3, 2));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 3));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 3));
        Assertions.assertEquals(transparent, texture.getColorAt(3, 4));
    }

    @Test
    public void setColor() {
        StaticTexture.TextBuilder builder = new StaticTexture.TextBuilder(pixelFont).setText("A").setColor(Color.blue);
        StaticTexture texture = builder.build();

        Assertions.assertEquals(Color.blue, texture.getColorAt(1, 0));
        Assertions.assertEquals(Color.blue, texture.getColorAt(2, 0));
        Assertions.assertEquals(Color.blue, texture.getColorAt(0, 1));
        Assertions.assertEquals(Color.blue, texture.getColorAt(3, 1));
        Assertions.assertEquals(Color.blue, texture.getColorAt(0, 2));
        Assertions.assertEquals(Color.blue, texture.getColorAt(1, 2));
        Assertions.assertEquals(Color.blue, texture.getColorAt(2, 2));
        Assertions.assertEquals(Color.blue, texture.getColorAt(3, 2));
        Assertions.assertEquals(Color.blue, texture.getColorAt(0, 3));
        Assertions.assertEquals(Color.blue, texture.getColorAt(3, 3));
        Assertions.assertEquals(Color.blue, texture.getColorAt(0, 4));
        Assertions.assertEquals(Color.blue, texture.getColorAt(3, 4));

        Color transparent = new Color(0, 0, 0, 0);
        Assertions.assertEquals(transparent, texture.getColorAt(0, 0));
        Assertions.assertEquals(transparent, texture.getColorAt(3, 0));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 1));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 1));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 3));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 3));
        Assertions.assertEquals(transparent, texture.getColorAt(1, 4));
        Assertions.assertEquals(transparent, texture.getColorAt(2, 4));
    }

    @Test
    public void setAnchorPoint() {
        StaticTexture.TextBuilder builder1 = new StaticTexture.TextBuilder(pixelFont).setText("A");
        StaticTexture texture1 = builder1.build();

        Assertions.assertEquals(0, texture1.getAnchorPoint().getX());
        Assertions.assertTrue(texture1.getAnchorPoint().getY() > 0);

        StaticTexture.TextBuilder builder2 = new StaticTexture.TextBuilder(pixelFont).setText("A").setAnchorPoint(0, 1);
        StaticTexture texture2 = builder2.build();

        Assertions.assertTrue(new Vec2D(0, 1).isSimilar(texture2.getAnchorPoint()));

        StaticTexture.TextBuilder builder3 = new StaticTexture.TextBuilder(pixelFont).setText("A").setAnchorPoint(new Vec2D(10, 3));
        StaticTexture texture3 = builder3.build();

        Assertions.assertTrue(new Vec2D(10, 3).isSimilar(texture3.getAnchorPoint()));
    }
}
