package com.mjc.stage2;

public class ThreadSafeSingleton {
    // Write your code here!
    private static volatile ThreadSafeSingleton instance;
    private String data;

    private ThreadSafeSingleton(String data) {
        this.data = data;
    }
    public static ThreadSafeSingleton getInstance(String data) {
        ThreadSafeSingleton result = instance;
        if (result == null) {
            synchronized (ThreadSafeSingleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new ThreadSafeSingleton(data);
                }
            }
        }
        return result;
    }
}