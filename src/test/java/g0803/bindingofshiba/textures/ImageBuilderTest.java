package g0803.bindingofshiba.textures;

import g0803.bindingofshiba.math.Vec2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageBuilderTest {

    private BufferedImage getImage() {
        BufferedImage image = new BufferedImage(3, 2, BufferedImage.TYPE_INT_ARGB);

        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.green);
        graphics.drawRect(0, 0, 2, 2);
        graphics.setColor(Color.red);
        graphics.drawRect(2, 0, 1, 2);

        return image;
    }

    @Test
    public void setAnchorPoint() {
        StaticTexture.ImageBuilder builder1 = new StaticTexture.ImageBuilder(0, 0);
        StaticTexture texture1 = builder1.setAnchorPoint(1, 2).build();

        StaticTexture.ImageBuilder builder2 = new StaticTexture.ImageBuilder(0, 0);
        StaticTexture texture2 = builder2.setAnchorPoint(new Vec2D(1, 2)).build();

        Assertions.assertTrue(new Vec2D(1, 2).isSimilar(texture1.getAnchorPoint()));
        Assertions.assertTrue(new Vec2D(1, 2).isSimilar(texture2.getAnchorPoint()));
    }

    @Test
    public void copiesImage() {
        BufferedImage image = getImage();

        StaticTexture.ImageBuilder builder = new StaticTexture.ImageBuilder(image);
        StaticTexture texture = builder.build();

        Assertions.assertEquals(image.getWidth(), texture.getWidth());
        Assertions.assertEquals(image.getHeight(), texture.getHeight());

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Assertions.assertEquals(image.getRGB(x, y), texture.getColorAt(x, y).getRGB());
            }
        }
    }

    @Test
    public void loadsImage() {
        BufferedImage image = getImage();

        StaticTexture.ImageBuilder builder = new StaticTexture.ImageBuilder(image.getWidth(), image.getHeight());
        StaticTexture texture = builder.loadImageData(image).build();

        Assertions.assertEquals(image.getWidth(), texture.getWidth());
        Assertions.assertEquals(image.getHeight(), texture.getHeight());

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Assertions.assertEquals(image.getRGB(x, y), texture.getColorAt(x, y).getRGB());
            }
        }
    }

    @Test
    public void defaultAnchorPoint() {
        StaticTexture.ImageBuilder builder = new StaticTexture.ImageBuilder(12, 4);
        StaticTexture texture = builder.build();

        Assertions.assertTrue(new Vec2D(0, 0).isSimilar(texture.getAnchorPoint()));
    }

    @Test
    public void setPixelAt() {
        BufferedImage image = getImage();

        StaticTexture.ImageBuilder builder = new StaticTexture.ImageBuilder(image);
        StaticTexture texture = builder
                .setPixelAt(0, 0, Color.blue)
                .build();

        Assertions.assertEquals(image.getWidth(), texture.getWidth());
        Assertions.assertEquals(image.getHeight(), texture.getHeight());

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (x == 0 && y == 0)
                    Assertions.assertEquals(Color.blue.getRGB(), texture.getColorAt(x, y).getRGB());
                else
                    Assertions.assertEquals(image.getRGB(x, y), texture.getColorAt(x, y).getRGB());
            }
        }
    }

    @Test
    public void pixelModificationMustBeDoneInsideTheImageArea() {
        StaticTexture.ImageBuilder builder = new StaticTexture.ImageBuilder(2, 3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> builder.setPixelAt(5, 2, Color.red));
        Assertions.assertThrows(IllegalArgumentException.class, () -> builder.setPixelAt(-1, 0, Color.blue));
        Assertions.assertThrows(IllegalArgumentException.class, () -> builder.setPixelAt(1, -1, Color.gray));
        Assertions.assertThrows(IllegalArgumentException.class, () -> builder.setPixelAt(0, 5, Color.red));
    }

    @Test
    public void loadResourceData() throws IOException {
        StaticTexture texture = new StaticTexture.ImageBuilder(2, 3)
                .loadResourceData("/texture.png")
                .build();

        Assertions.assertEquals(new Color(168, 247, 27), texture.getColorAt(0, 0));
        Assertions.assertEquals(new Color(14, 132, 120), texture.getColorAt(0, 1));
        Assertions.assertEquals(new Color(68, 71, 236), texture.getColorAt(0, 2));
        Assertions.assertEquals(new Color(80, 0, 226), texture.getColorAt(1, 0));
        Assertions.assertEquals(new Color(24, 240, 218), texture.getColorAt(1, 1));
        Assertions.assertEquals(new Color(236, 68, 228), texture.getColorAt(1, 2));
    }

    @Test
    public void throwsIfResourceNotFound() {
        StaticTexture.ImageBuilder builder = new StaticTexture.ImageBuilder(3, 4);
        Assertions.assertThrows(IOException.class, () -> builder.loadResourceData("/404.png"));
    }

    @Test
    public void throwsIfDimensionsDontMatch() {
        BufferedImage image = getImage();

        StaticTexture.ImageBuilder builder = new StaticTexture.ImageBuilder(3, 4);
        Assertions.assertThrows(IllegalArgumentException.class, () -> builder.loadImageData(image));
    }
}
