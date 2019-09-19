package com.github.jengo.javacommand;

/**
 * {@link JStackDemo}
 */
public class JStackDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockTask(true));  //建立一个线程
        Thread t2 = new Thread(new DeadLockTask(false)); //建立另一个线程
        t1.start(); //启动一个线程
        t2.start(); //启动另一个线程
    }
}

class DeadLockTask implements Runnable {
    public boolean flag;// 控制线程

    DeadLockTask(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        /*如果flag的值为true则调用t1线程*/
        if (flag) {
            while (true) {
                synchronized (Suo.o1) {
                    System.out.println("o1 " + Thread.currentThread().getName());
                    synchronized (Suo.o2) {
                        System.out.println("o2 " + Thread.currentThread().getName());
                    }
                }
            }
        }
        /*如果flag的值为false则调用t2线程*/
        else {
            while (true) {
                synchronized (Suo.o2) {
                    System.out.println("o2 " + Thread.currentThread().getName());
                    synchronized (Suo.o1) {
                        System.out.println("o1 " + Thread.currentThread().getName());
                    }
                }
            }
        }
    }
}

class Suo {
    static Object o1 = new Object();
    static Object o2 = new Object();
}
