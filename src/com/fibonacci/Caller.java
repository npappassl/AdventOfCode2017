package com.fibonacci;

public class Caller {
    public static void main(String[] args){
        System.out.println("Starting");
        Long s = System.currentTimeMillis();
        Fibonacci r = new Recursive();
        long recRes = r.fib(50);
        System.out.println(System.currentTimeMillis()-s + "ms");
        System.out.println(recRes);
        s = System.currentTimeMillis();
        Fibonacci rd = new RecursiveDynamic();
        long recResDyn = rd.fib(50);
        System.out.println(System.currentTimeMillis()-s + "ms");
        System.out.println(recResDyn);
        s = System.currentTimeMillis();
        Fibonacci b = new Boring();
        long recBor = b.fib(50);
        System.out.println(System.currentTimeMillis()-s + "ms");
        System.out.println(recBor);
    }
}
