package com.maps;

import javafx.util.Pair;

import java.util.List;
import java.util.Set;

public interface MyMap<K,V> {
    public V get(K key);
    public void put(K key,V value);
    public List<V> getValues();
    public Set<K> getKeys();
    public List<Pair<K,V>> getEntries();
}
