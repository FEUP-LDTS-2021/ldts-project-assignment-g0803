package g0803.bindingofshiba.collections;

import java.util.HashMap;
import java.util.Set;

public class HashMapBundle<T> implements Bundle<T> {

    private final HashMap<String, T> bundle = new HashMap<>();

    public void register(String name, T data) {
        bundle.put(name, data);
    }

    public T get(String name) {
        if (!bundle.containsKey(name))
            throw new IllegalArgumentException("Key not found in bundle");

        return bundle.get(name);
    }
}
