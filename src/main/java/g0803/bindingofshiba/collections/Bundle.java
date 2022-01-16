package g0803.bindingofshiba.collections;

import java.util.Set;

public interface Bundle<T> {
    void register(String name, T data);

    T get(String name);
}
