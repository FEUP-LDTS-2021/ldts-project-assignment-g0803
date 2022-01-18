package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Door;
import g0803.bindingofshiba.model.game.DoorPosition;
import g0803.bindingofshiba.model.game.Room;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Obstacle;
import g0803.bindingofshiba.textures.ITexture;
import g0803.bindingofshiba.view.View;

import java.util.Locale;
import java.util.Map;

public class RoomView extends View<Room> {

    public RoomView(Room model) { super(model); }

    private ITexture getTextureFromDoorPosition(Bundle<ITexture> textures, DoorPosition doorPosition) {
        StringBuilder builder = new StringBuilder();
        builder.append("room.walls.");
        builder.append(getModel().getDoors().containsKey(doorPosition) ? "open." : "closed.");
        builder.append(doorPosition.name().toLowerCase(Locale.ROOT));
        return textures.get(builder.toString());
    }

    @Override
    public void draw(App app, GUI gui, Vec2D offset) {
        Map<DoorPosition, Door> doors = getModel().getDoors();
        Bundle<ITexture> textures = app.getTextures();

        for (DoorPosition doorPosition : DoorPosition.values()) {
            ITexture texture = getTextureFromDoorPosition(app.getTextures(), doorPosition);
            gui.blit(0, 0, texture);
        }

        for (Door door : doors.values()) {
            gui.blit((int) door.getPositionByWall(getModel()).getX(), (int) door.getPositionByWall(getModel()).getY(), door.getUnlocked() ? textures.get("door.open") : textures.get("door.closed"));
        }

        for (Obstacle obstacle : getModel().getObstacles()) {
            gui.blit((int) obstacle.getPosition().getX(), (int) obstacle.getPosition().getY(), textures.get("rock"));
        }

        for (Monster monster : getModel().getMonsters()) {
            gui.blit((int) monster.getPosition().getX(), (int) monster.getPosition().getY(), textures.get("monster.normal"));
        }
    }
}
