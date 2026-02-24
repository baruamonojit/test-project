package com.edu.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T6_PubSubBlockingQueue {

    static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
    static int counter =0;

    public static void main(String[] args) throws Exception {

        Thread pub = new Thread(()-> {
            while (true) {
                try {
                    queue.put("Pub message " + counter++);
                    //queue.add("Pub message " + counter++);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread sub = new Thread(()-> {
            while(true) {
                try{
                    String message = queue.take();
                    //String message = queue.poll();
                    System.out.println("Message consumed: " + message);
                    Thread.sleep(300);
                }catch(Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        pub.start();
        sub.start();
    }
}
