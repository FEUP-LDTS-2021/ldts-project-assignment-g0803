package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.DoorPosition;
import g0803.bindingofshiba.model.game.Room;
import g0803.bindingofshiba.textures.ITexture;
import g0803.bindingofshiba.view.View;

public class RoomView extends View<Room> {

    public RoomView(Room model) { super(model); }

    private ITexture getTextureFromDoorPosition(Bundle<ITexture> textures, DoorPosition doorPosition) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void draw(App app, GUI gui, Vec2D offset) {
        throw new RuntimeException("Not implemented");
    }
}
