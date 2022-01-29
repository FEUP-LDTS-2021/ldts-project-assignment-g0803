package g0803.bindingofshiba.bundles;

import g0803.bindingofshiba.math.BoundingBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class DefaultBoundingBoxesProviderTest {

    @Test
    public void hasRequiredKeys() {
        Bundle<BoundingBox> bundle = new DefaultBoundingBoxesProvider().getBundle();

        Set<String> actual = bundle.keys();
        Set<String> expected =
                Set.of(
                        "monster",
                        "shiba",
                        "room",
                        "projectile",
                        "rock");

        Assertions.assertEquals(expected, actual);

        for (String key : expected) Assertions.assertNotNull(bundle.get(key));
    }
}
