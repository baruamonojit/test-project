package com.edu.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T1_ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i=0;i<5;i++) {
            int taskNo = i;
            pool.submit(()-> {
                System.out.println("Threadpool"+ taskNo +" name: "+ Thread.currentThread().getName());
            });
        }
        pool.shutdown();
    }
}
