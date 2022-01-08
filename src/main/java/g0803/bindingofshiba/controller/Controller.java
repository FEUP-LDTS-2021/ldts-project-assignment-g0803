package g0803.bindingofshiba.controller;

import g0803.bindingofshiba.App;
import java.io.IOException;

public abstract class Controller<T> {

    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void tick(App app) throws IOException;
}
