package com.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class Hasher {
    final int val;

    Hasher(int val) {
        this.val =val;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hasher hasher = (Hasher) o;
        return val == hasher.val;
    }

    @Override
    public String toString() {
        return ""+val;
    }
}

class MyHashMapTest {

    @Test
    void twoDifferentKeysWithSameHashCode() {
        Hasher one = new Hasher(1);

        MyMap<Hasher,String> map = new MyHashMap<>(3);
        map.put(one, "one");
        assertEquals("one", map.get(new Hasher(1)));
        assertEquals(null, map.get(new Hasher(2)));
    }

    @Test
    void twoPuttingDifferentKeysWithSameHashCode() {
        Hasher one = new Hasher(1);
        Hasher two = new Hasher(2);


        MyMap<Hasher,String> map = new MyHashMap<>(3);
        map.put(one, "one");
        map.put(two, "two");

        assertEquals("one", map.get(new Hasher(1)));
    }

    @Test
    void instantiatePutGetStringInteger() {
        MyMap<String,Integer> map = new MyHashMap<>(3);
        map.put("hey1", 30);
        map.put("hey2", 31);
        map.put("hey3", 32);
        map.put("hey4", 33);
        map.put("hey5", 34);
        assertEquals(30,map.get("hey1").intValue());
        assertEquals(31,map.get("hey2").intValue());
        assertEquals(32,map.get("hey3").intValue());
        assertEquals(33,map.get("hey4").intValue());
        assertEquals(34,map.get("hey5").intValue());
    }
    @Test
    void instantiatePutGetStringString() {
        MyMap<String,String> map = new MyHashMap<>(3);
        map.put("hey1", "30");
        map.put("hey2", "31");
        map.put("hey3", "32");
        map.put("hey4", "33");
        map.put("hey5", "34");
        assertEquals("30",map.get("hey1"));
        assertEquals("31",map.get("hey2"));
        assertEquals("32",map.get("hey3"));
        assertEquals("33",map.get("hey4"));
        assertEquals("34",map.get("hey5"));
    }
    @Test
    void rehashingWithSmallInitialSize() {
        MyMap<String,String> map = new MyHashMap<>(1);
        map.put("hey1", "30");
        map.put("hey2", "31");
        map.put("hey3", "32");
        map.put("hey4", "33");
        map.put("hey5", "34");
        assertEquals("30",map.get("hey1"));
        assertEquals("31",map.get("hey2"));
        assertEquals("32",map.get("hey3"));
        assertEquals("33",map.get("hey4"));
        assertEquals("34",map.get("hey5"));
    }
    @Test
    void rehashingWithInitialSizeZero() {
        MyMap<String,String> map = new MyHashMap<>(0);
        map.put("hey1", "30");
        map.put("hey2", "31");
        map.put("hey3", "32");
        map.put("hey4", "33");
        map.put("hey5", "34");
        assertEquals("30",map.get("hey1"));
        assertEquals("31",map.get("hey2"));
        assertEquals("32",map.get("hey3"));
        assertEquals("33",map.get("hey4"));
        assertEquals("34",map.get("hey5"));
    }

}