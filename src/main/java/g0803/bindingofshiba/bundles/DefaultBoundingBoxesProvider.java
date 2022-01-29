package g0803.bindingofshiba.bundles;

import g0803.bindingofshiba.math.BoundingBox;

public class DefaultBoundingBoxesProvider implements BundleProvider<BoundingBox> {

    private final Bundle<BoundingBox> boundingBoxes = new HashMapBundle<>();

    public DefaultBoundingBoxesProvider() {
        this.registerBoundingBoxes();
    }

    private void registerBoundingBoxes() {
        boundingBoxes.register("monster", new BoundingBox(-4, -3, 10, 4));
        boundingBoxes.register("shiba", new BoundingBox(-3, -6, 7, 7));
        boundingBoxes.register("room", new BoundingBox(3, 3, 137, 60));
        boundingBoxes.register("projectile", new BoundingBox(-2, -2, 5, 5));
        boundingBoxes.register("rock", new BoundingBox(-4, -10, 9, 2));
    }

    @Override
    public Bundle<BoundingBox> getBundle() {
        return boundingBoxes;
    }
}
