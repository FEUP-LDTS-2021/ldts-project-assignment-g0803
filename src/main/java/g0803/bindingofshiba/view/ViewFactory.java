package g0803.bindingofshiba.view;

public interface ViewFactory<T> {

    View<T> create(T model);
}
