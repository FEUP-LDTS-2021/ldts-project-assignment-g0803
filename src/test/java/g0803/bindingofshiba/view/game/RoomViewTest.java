package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Door;
import g0803.bindingofshiba.model.game.DoorPosition;
import g0803.bindingofshiba.model.game.Room;
import g0803.bindingofshiba.textures.ITexture;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RoomViewTest {

    @Test
    public void blitsDoorClosed() {
        Room r1 = new Room(143, 75, null, null);
        Room r2 = new Room(143, 75, null, null);

        Door door = new Door(r1, DoorPosition.TOP, r2, DoorPosition.BOTTOM);
        r1.addDoor(door);

        App app = Mockito.mock(App.class);
        GUI gui = Mockito.mock(GUI.class);

        Bundle<ITexture> textures = Mockito.mock(Bundle.class);
        ITexture texture = Mockito.mock(ITexture.class);

        Mockito.when(app.getTextures()).thenReturn(textures);
        Mockito.when(textures.get("door.closed")).thenReturn(texture);

        RoomView view = new RoomView(r1);

        view.draw(app, gui, Vec2D.zero());

        Mockito.verify(gui).blit(71, 0, texture);
    }
}
