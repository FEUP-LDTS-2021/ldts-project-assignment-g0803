package g0803.bindingofshiba.textures;

import g0803.bindingofshiba.collisions.BoundingBox;
import g0803.bindingofshiba.math.Vec2D;
import java.awt.*;

public interface ITexture {

    int getWidth();

    int getHeight();

    Vec2D getAnchorOffset(Vec2D position);

    Vec2D getAnchorOffset(int x, int y);

    BoundingBox getTextureBoundingBox();

    Color getColorAt(int x, int y);
}
