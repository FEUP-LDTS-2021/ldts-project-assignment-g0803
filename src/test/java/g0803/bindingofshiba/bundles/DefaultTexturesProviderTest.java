package g0803.bindingofshiba.bundles;

import g0803.bindingofshiba.textures.ITexture;
import g0803.bindingofshiba.textures.StaticTexture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class DefaultTexturesProviderTest {

    private static DefaultTexturesProvider provider;

    @BeforeAll
    public static void setUp() throws IOException {
        provider = new DefaultTexturesProvider();
    }

    @Test
    public void hasRequiredKeys() {
        Bundle<ITexture> bundle = provider.getBundle();

        Set<String> actual = bundle.keys();
        Set<String> expected = Set.of(
                "shiba",
                "rock",
                "hud",
                "heart",
                "room.walls.left",
                "room.walls.right",
                "room.walls.bottom",
                "room.walls.top",
                "monster.aura.idle",
                "monster.aura.attack",
                "monster.damaged",
                "monster.normal",
                "key",
                "health.changing",
                "health.idle",
                "door.closed.vertical",
                "door.closed.horizontal",
                "door.open.right",
                "door.open.top",
                "door.open.left",
                "door.open.bottom"
        );

        Assertions.assertEquals(expected, actual);

        for (String key : expected)
            Assertions.assertNotNull(bundle.get(key));
    }
}
