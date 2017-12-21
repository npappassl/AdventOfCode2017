package com.fibonacci;

import java.util.HashMap;

public class RecursiveDynamic implements Fibonacci {
    private HashMap<Integer, Long> mem;
    public RecursiveDynamic(){
        mem = new HashMap<>();
        mem.put(0,0L);
        mem.put(1,1L);
    }
    @Override
    public long fib(int n){
        if(mem.containsKey(n)) return mem.get(n);
        long result = fib(n-1)+fib(n-2);
        mem.put(n,result);
        return result;
    }
}
