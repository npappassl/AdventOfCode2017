package com.maps;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private int size = 16;
    private static final float completnessLimit = 0.75f;

    private List<List<Pair<K,V>>> map;
    private Set<K> keys;
    private float completnessRatio;

    public MyHashMap() {
        instantiateFields();
    }

    public MyHashMap(int size) {
        this.size = size;
        instantiateFields();
    }

    private void instantiateFields() {
        map = new ArrayList<>(Collections.nCopies(size, new LinkedList<>()));
        keys = new HashSet<>();
        completnessRatio = 0f;
    }

    @Override
    public V get(K key) {
        int hash = makeHash(key);
        for(Pair<K,V> p: map.get(hash)){
            if(p.getKey().equals(key)) return p.getValue();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        calcCompletnessRatio();
        if (completnessRatio > completnessLimit) rehash();
        int hash = makeHash(key);
        if (!keys.contains(key)) {
            keys.add(key);
            map.get(hash).add(new Pair<>(key,value));
        } else {
            List<Pair<K,V>> bucket = map.get(hash);
            for(int i=0;i<bucket.size();i++){
                if(bucket.get(i).getKey().equals(key))  bucket.set(i,new Pair<>(key, value));
                return;
            }
        }

    }

    private void calcCompletnessRatio() {
        int count = 0;
        if (size == 0) completnessRatio = 1f;
        else completnessRatio = keys.size() / size;
    }

    @Override
    public List<V> getValues() {
        return map.stream().flatMap(x-> x.stream()).map(x -> x.getValue()).collect(Collectors.toList());
    }

    @Override
    public List<Pair<K,V>> getEntries() {
        return map.stream().flatMap(x-> x.stream()).collect(Collectors.toList());
    }

    @Override
    public Set<K> getKeys() {
        return new HashSet<>(keys);
    }

    private void rehash() {
        if(size==0) size = 1;
        int tempSize = size * 2;
//        alternatively I would instantiate a new arraylist as in the constructor
        MyHashMap<K, V> temp = new MyHashMap<>(tempSize);
        keys.stream().forEach(x -> temp.put(x, get(x)));
        map = temp.map;
        size = tempSize;
    }

    private int makeHash(K key) {
        return key.hashCode() % size;
    }

}
