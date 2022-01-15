package g0803.bindingofshiba.textures;

import g0803.bindingofshiba.collisions.BoundingBox;
import g0803.bindingofshiba.math.Vec2D;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class StaticTexture implements ITexture {

    public static class TextBuilder implements ITextureBuilder {

        public TextBuilder setFont(Font font) {
            throw new RuntimeException("Not implemented");
        }

        public TextBuilder setText(String text) {
            throw new RuntimeException("Not implemented");
        }

        public TextBuilder setColor(String color) {
            throw new RuntimeException("Not implemented");
        }

        @Override
        public ITexture build() {
            throw new RuntimeException("Not implemented");
        }
    }

    public static class ImageBuilder implements ITextureBuilder {

        public ImageBuilder(int width, int height) {
            throw new RuntimeException("Not implemented");
        }

        public ImageBuilder(BufferedImage image) {
            throw new RuntimeException("Not implemented");
        }

        public ImageBuilder setAnchorPoint(double x, double y) {
            throw new RuntimeException("Not implemented");
        }

        public ImageBuilder setAnchorPoint(Vec2D anchorPoint) {
            throw new RuntimeException("Not implemented");
        }

        public ImageBuilder loadImageData(BufferedImage image) {
            throw new RuntimeException("Not implemented");
        }

        public ImageBuilder loadResourceData(String location) throws IOException {
            throw new RuntimeException("Not implemented");
        }

        public ImageBuilder setPixelAt(int x, int y, Color c) {
            throw new RuntimeException("Not implemented");
        }

        @Override
        public StaticTexture build() {
            throw new RuntimeException("Not implemented");
        }
    }

    public StaticTexture(int width, int height, Vec2D anchorPoint, Color[] pixels) {
        throw new RuntimeException("Not implemented");
    }

    public StaticTexture(StaticTexture texture, Vec2D anchorPoint) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getWidth() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getHeight() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Vec2D getAnchorOffset(int x, int y) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Vec2D getAnchorOffset(Vec2D position) {
        throw new RuntimeException("Not implemented");
    }

    public Vec2D getAnchorPoint() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public BoundingBox getTextureBoundingBox() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Color getColorAt(int x, int y) {
        throw new RuntimeException("Not implemented");
    }

    public StaticTexture rotateLeft() {
        throw new RuntimeException("Not implemented");
    }

    public StaticTexture rotateRight() {
        throw new RuntimeException("Not implemented");
    }

    public StaticTexture flipVertically() {
        throw new RuntimeException("Not implemented");
    }

    public StaticTexture flipHorizontally() {
        throw new RuntimeException("Not implemented");
    }
}