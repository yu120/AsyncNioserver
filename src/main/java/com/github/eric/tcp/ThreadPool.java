package com.github.eric.tcp;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by eric567 on 8/18/2016.
 */
public class ThreadPool extends ThreadPoolExecutor {

    private static ThreadPool threadPool;


    private ThreadPool() {
        super(5, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }


    public static ThreadPool getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * Singleton implementation helper.
     */
    private static class SingletonHolder {
        // This gets initialized on first reference
        // to SingletonHolder.
        static final ThreadPool instance = new ThreadPool();
    }

}