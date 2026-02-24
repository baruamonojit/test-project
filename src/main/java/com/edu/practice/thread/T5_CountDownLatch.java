package com.edu.practice.thread;

import java.util.concurrent.CountDownLatch;

public class T5_CountDownLatch {

    static CountDownLatch latch = new CountDownLatch(3);


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new RunnableTest(latch));
        Thread t2 = new Thread(new RunnableTest(latch));
        Thread t3 = new Thread(new RunnableTest(latch));

        t1.start();
        t2.start();
        t3.start();

        latch.await();
        System.out.println("Final exit");

    }
}

class RunnableTest implements Runnable {
    CountDownLatch latch;
    public RunnableTest(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + latch.getCount());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        latch.countDown();
    }

}
