package g0803.bindingofshiba.view;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.textures.ITexture;

public abstract class View<T> {

    private final T model;

    public View(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void draw(App app, GUI gui, Vec2D offset);
}
