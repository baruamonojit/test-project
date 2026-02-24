package com.edu.practice.thread;

public class T3_OddEven {
    static Object o1 = new Object();
    static int num =0;
    static int max =10;
    public static void main(String[] args) {


        Thread odd = new Thread(()-> {
            while (num <= max) {
               synchronized (o1) {
                    while(num %2==0) {
                        try{
                            o1.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (num<=max){
                        System.out.println("Odd : " + num++);
                        o1.notify();
                    }
               }
            }
        });
        Thread even = new Thread(()-> {
            while (num < max) {
                synchronized (o1) {
                    while (num%2!=0) {
                        try{
                            o1.wait();
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (num<=max) {
                        System.out.println("Even: " + num++);
                        o1.notify();
                    }
                }
            }
        });

        odd.start();
        even.start();

    }
}
