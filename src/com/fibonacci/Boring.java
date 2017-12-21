package com.fibonacci;

public class Boring implements Fibonacci {
    @Override
    public long fib(int n){
        if(n==0) return 0;
        long prev = 0L;
        long current = 1L;
        for(int i=1;i<n;i++){
            long next = prev+current;
            prev = current;
            current = next;
        }
        return current;
    }
}
