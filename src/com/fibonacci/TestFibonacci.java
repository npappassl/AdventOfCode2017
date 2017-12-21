package com.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFibonacci {
    Fibonacci r;
    Fibonacci rd;
    Fibonacci b;
    @BeforeEach
    public void setup(){
        r = new Recursive();
        rd = new RecursiveDynamic();
        b = new Boring();
    }
    @Test
    public void fib10R(){
        assertEquals(55L,r.fib(10));
    }

    @Test
    public void fib10RD(){
        assertEquals(55L,rd.fib(10));
    }
    @Test
    public void fib10B(){
        assertEquals(55L,b.fib(10));
    }
    @Test
    public void fib20R(){
        assertEquals(6765L,r.fib(20));
    }

    @Test
    public void fib20RD(){
        assertEquals(6765L,rd.fib(20));
    }
    @Test
    public void fib20B(){
        assertEquals(6765L,b.fib(20));
    }
    @Test
    public void fib50R(){
        assertEquals(12586269025L,r.fib(50));
    }

    @Test
    public void fib50RD(){
        assertEquals(12586269025L,rd.fib(50));
    }
    @Test
    public void fib50B(){
        assertEquals(12586269025L,b.fib(50));
    }

}
