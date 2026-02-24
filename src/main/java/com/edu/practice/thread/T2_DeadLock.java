package com.edu.practice.thread;

public class T2_DeadLock {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new Thread(() -> {
                    try {
                        synchronized (o1) {
                            System.out.println("Thread1 got lock on o1");
                            Thread.sleep(1000);
                            synchronized (o2) {
                                System.out.println("Thread1 got lock on o2");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        });

        Thread t2 = new Thread(() -> {
            try{
                synchronized (o1) {
                    System.out.println("Thread2 got lock on o2");
                    Thread.sleep(1000);
                    synchronized (o2){
                        System.out.println("Thread2 got lock on o1");
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
