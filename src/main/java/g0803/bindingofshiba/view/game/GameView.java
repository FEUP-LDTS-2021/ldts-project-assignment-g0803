package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Element;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;
import g0803.bindingofshiba.textures.ITexture;
import g0803.bindingofshiba.textures.TextTextureBuilder;
import g0803.bindingofshiba.view.View;
import g0803.bindingofshiba.view.ViewFactory;
import java.awt.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameView extends View<Game> {

    private final View<Player> playerView;
    private final List<? extends View<Monster>> monsterViews;

    public GameView(
            Game model,
            ViewFactory<Player> playerViewFactory,
            ViewFactory<Monster> monsterViewFactory) {
        super(model);

        this.playerView = playerViewFactory.create(getModel().getPlayer());
        this.monsterViews =
                getModel().getMonsters().stream()
                        .map(monsterViewFactory::create)
                        .collect(Collectors.toList());
    }

    private void drawPlayer(App app, GUI gui, Vec2D offset) {
        playerView.draw(app, gui, offset);
    }

    private void drawElementsBelowPlayer(App app, GUI gui, Vec2D offset) {
        drawElements(
                app,
                gui,
                offset,
                element ->
                        element.getPosition().round().getY()
                                >= getModel().getPlayer().getPosition().round().getY());
    }

    private void drawElementsOnTopOfPlayer(App app, GUI gui, Vec2D offset) {
        drawElements(
                app,
                gui,
                offset,
                element ->
                        element.getPosition().round().getY()
                                < getModel().getPlayer().getPosition().round().getY());
    }

    private void drawElements(App app, GUI gui, Vec2D offset, Predicate<Element> shouldRender) {
        for (View<Monster> view : monsterViews) {
            if (shouldRender.test(view.getModel())) {
                view.draw(app, gui, offset);
            }
        }
    }

    private void drawHud(App app, GUI gui, Vec2D offset) {
        drawHealthBar(app, gui, offset);
        drawOverlay(app, gui, offset);
        drawKeys(app, gui, offset);
    }

    private void drawHealthBar(App app, GUI gui, Vec2D offset) {
        Bundle<ITexture> textures = app.getTextures();
        ITexture texture = textures.get("health.idle");

        int currentHp = getModel().getPlayer().getHp();
        int maxHp = getModel().getPlayer().getMaxHp();
        double percentage = (double) currentHp / maxHp;
        double x = 0.5 * percentage * texture.getWidth();

        Vec2D position = new Vec2D(x, 0).add(offset).round();
        gui.blit((int) position.getX(), (int) position.getY(), texture);
    }

    private void drawOverlay(App app, GUI gui, Vec2D offset) {
        Bundle<ITexture> textures = app.getTextures();
        ITexture texture = textures.get("hud");

        Vec2D position = offset.round();
        gui.blit((int) position.getX(), (int) position.getY(), texture);
    }

    private void drawKeys(App app, GUI gui, Vec2D offset) {
        Bundle<Font> fonts = app.getFonts();
        Font font = fonts.get("text");

        String keys = String.valueOf(getModel().getPlayer().getNumberOfKeys());
        ITexture texture =
                new TextTextureBuilder(font).setText(keys).setColor(Color.lightGray).build();

        Vec2D position = new Vec2D(9, 6).add(offset).round();

        gui.blit((int) position.getX(), (int) position.getY(), texture);
    }

    @Override
    public void draw(App app, GUI gui, Vec2D offset) {
        gui.fill(new Color(90, 72, 53));

        drawElementsOnTopOfPlayer(app, gui, offset.add(new Vec2D(0, 9)));
        drawPlayer(app, gui, offset.add(new Vec2D(0, 9)));
        drawElementsBelowPlayer(app, gui, offset.add(new Vec2D(0, 9)));
        drawHud(app, gui, offset);
    }
}
