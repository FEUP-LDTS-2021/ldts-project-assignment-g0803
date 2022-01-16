package g0803.bindingofshiba.textures;

import g0803.bindingofshiba.math.Vec2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageTextureBuilder implements ITextureBuilder {

    public ImageTextureBuilder(int width, int height) {
        throw new RuntimeException("Not implemented");
    }

    public ImageTextureBuilder(BufferedImage image) {
        throw new RuntimeException("Not implemented");
    }

    public ImageTextureBuilder setAnchorPoint(double x, double y) {
        throw new RuntimeException("Not implemented");
    }

    public ImageTextureBuilder setAnchorPoint(Vec2D anchorPoint) {
        throw new RuntimeException("Not implemented");
    }

    public ImageTextureBuilder loadImageData(BufferedImage image) {
        throw new RuntimeException("Not implemented");
    }

    public ImageTextureBuilder loadResourceData(String location) throws IOException {
        throw new RuntimeException("Not implemented");
    }

    public ImageTextureBuilder setPixelAt(int x, int y, Color c) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public StaticTexture build() {
        throw new RuntimeException("Not implemented");
    }

}
