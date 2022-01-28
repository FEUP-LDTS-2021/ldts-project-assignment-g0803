package g0803.bindingofshiba.factory;

import g0803.bindingofshiba.view.View;

public interface ViewFactory<T> {

    View<T> create(T model);
}
