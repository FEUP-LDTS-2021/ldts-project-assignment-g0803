package g0803.bindingofshiba.collections;

import java.util.HashMap;
import java.util.Set;

public class HashMapBundle<T> implements Bundle<T> {

    public void register(String name, T data) {
        throw new RuntimeException("Not implemented");
    }

    public T get(String name) {
        throw new RuntimeException("Not implemented");
    }
}
