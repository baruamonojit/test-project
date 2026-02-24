package com.edu.practice.thread;

import java.util.concurrent.Semaphore;

public class T4_OddEvenSemaphore {

    static Semaphore odd = new Semaphore(1);
    static Semaphore even = new Semaphore(0);
    static int num=1, max=10;

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            try{
                while (num<max) {
                    odd.acquire();
                    System.out.println("Odd: " + num++);
                    even.release();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        });

        Thread evenThread = new Thread(() -> {
            try{
                while(num<max){
                    even.acquire();
                    System.out.println("Even: " + num++);
                    odd.release();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        oddThread.start();
        evenThread.start();
    }

}
