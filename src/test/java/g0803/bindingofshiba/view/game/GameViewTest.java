package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.bundles.DefaultFontsProvider;
import g0803.bindingofshiba.factory.ViewFactory;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;
import g0803.bindingofshiba.textures.ITexture;
import g0803.bindingofshiba.view.View;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class GameViewTest {

    private static Font font;

    @BeforeAll
    public static void setup() throws IOException, FontFormatException {
        URL resource = DefaultFontsProvider.class.getResource("/fonts/cg-pixel-4x5.ttf");
        InputStream fileStream = resource.openStream();
        Font font = Font.createFont(Font.TRUETYPE_FONT, fileStream);
        GameViewTest.font = font.deriveFont(Font.PLAIN, 5);
    }

    @Test
    public void draw() {
        App app = Mockito.mock(App.class);
        GUI gui = Mockito.mock(GUI.class);

        Bundle<ITexture> textures = Mockito.mock(Bundle.class);

        ITexture healthBarTexture = Mockito.mock(ITexture.class);
        Mockito.when(healthBarTexture.getWidth()).thenReturn(20);

        ITexture overlayTexture = Mockito.mock(ITexture.class);
        Mockito.when(textures.get("health.idle")).thenReturn(healthBarTexture);
        Mockito.when(textures.get("hud")).thenReturn(overlayTexture);

        Mockito.when(app.getTextures()).thenReturn(textures);

        Bundle<Font> fonts = Mockito.mock(Bundle.class);
        Mockito.when(fonts.get("text")).thenReturn(font);

        Mockito.when(app.getFonts()).thenReturn(fonts);

        View<Player> playerView = Mockito.mock(View.class);
        ViewFactory<Player> playerViewFactory = Mockito.mock(ViewFactory.class);

        View<Monster> monsterView1 = Mockito.mock(View.class);
        View<Monster> monsterView2 = Mockito.mock(View.class);
        ViewFactory<Monster> monsterViewFactory = Mockito.mock(ViewFactory.class);

        Mockito.when(playerViewFactory.create(Mockito.any())).thenReturn(playerView);
        Mockito.when(monsterViewFactory.create(Mockito.any()))
                .thenReturn(monsterView1, monsterView2);

        Player player = Mockito.mock(Player.class);
        Monster monster1 = Mockito.mock(Monster.class);
        Monster monster2 = Mockito.mock(Monster.class);

        Game game = Mockito.mock(Game.class);
        Mockito.when(game.getPlayer()).thenReturn(player);
        Mockito.when(player.getHp()).thenReturn(20);
        Mockito.when(player.getMaxHp()).thenReturn(40);

        Mockito.when(game.getMonsters()).thenReturn(Arrays.asList(monster1, monster2));

        GameView view = new GameView(game, playerViewFactory, monsterViewFactory);
        Mockito.verify(playerViewFactory).create(player);
        Mockito.verify(monsterViewFactory).create(monster1);
        Mockito.verify(monsterViewFactory).create(monster2);

        Vec2D offset = new Vec2D(1, 2);
        view.draw(app, gui, offset);

        InOrder inOrder = Mockito.inOrder(gui, playerView, monsterView1, monsterView2);

        inOrder.verify(gui).fill(Mockito.any());
        inOrder.verify(monsterView1).draw(app, gui, offset.add(new Vec2D(0, 9)));
        inOrder.verify(monsterView2).draw(app, gui, offset.add(new Vec2D(0, 9)));
        inOrder.verify(playerView).draw(app, gui, offset.add(new Vec2D(0, 9)));

        inOrder.verify(gui).blit(-4, 2, healthBarTexture);
        inOrder.verify(gui).blit(1, 2, overlayTexture);
        inOrder.verify(gui).blit(Mockito.eq(10), Mockito.eq(8), Mockito.any());
    }
}
