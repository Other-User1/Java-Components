package com.java.components.util;

import com.java.components.lang.CompilerTaskException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiHashMap<K, V> {
    private final Map<K, ArrayList<V>> map;

    public MultiHashMap() {
        this.map = new HashMap<>();
    }

    public MultiHashMap<K, V> put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("The value cannot be null");
        }

        // Obtén la lista de valores asociada a la clave, o crea una nueva si no existe
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);

        return this;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }
        return map.getOrDefault(key, new ArrayList<>()).get(0);
    }

    public V get(K key, int index) {
        if (key == null) {
            throw new IllegalArgumentException("The key cannot be null");
        }
        List<V> values = map.get(key);
        if (values != null && index >= 0 && index < values.size()) {
            return values.get(index);
        }
        return null;
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public boolean containsValue(V value) {
        return map.values().stream()
                .flatMap(List::stream)
                .anyMatch(val -> val.equals(value));
    }

    public void remove(K key) {
        map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}
