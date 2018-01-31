package com.ivo.chapter3.item18;

/**
 *
 * @author IOAdmin
 */
public class MapEntry<K, V> extends AbstractMapEntry<K, V>{

    @Override
    public K getKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public V getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        MapEntry<Integer, Integer> m = new MapEntry<>();
        m.setValue(5);
    }
}
