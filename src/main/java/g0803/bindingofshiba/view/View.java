package g0803.bindingofshiba.view;

import g0803.bindingofshiba.gui.GUI;

public abstract class View<T> {

    private final T model;

    public View(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void draw(GUI gui);
}
