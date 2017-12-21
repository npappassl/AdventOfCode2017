package com.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class TestCallable<T> implements Callable {

    @Override
    public T call() throws Exception {

        return (T) new Object();
    }
}
