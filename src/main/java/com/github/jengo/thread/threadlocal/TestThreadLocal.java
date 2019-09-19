package com.github.jengo.thread.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link TestThreadLocal}
 * https://mp.weixin.qq.com/s/k4cMqePHagb15-jlYh4PkA
 *
 * 能不能把某个值放到线程中，让线程携带着这个值到处跑，这样无论在任何地方都可以轻松获得这个值了；
 * 相当于把各自的数据放入到了各自Thread这个对象中去了，每个线程的值自然就区分开了；
 * ThreadLocal这个名字起得有点让人误解，很容易让人认为是"本地线程"，其实是用来维护本线程的变量；
 * ThreadLocal并不仅仅是Java中的概念，其他语言中也有，作用类似；
 * ThreadLocal在日常工作中用得不多，但是在框架中是个基础性的技术；
 */
public class TestThreadLocal {

    private static AtomicInteger nextHashCode = new AtomicInteger();
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        int hash = nextHashCode.getAndAdd(HASH_INCREMENT);
        System.out.println(hash);

        assert 1 == 2;

        ThreadLocal<String> threadLocalA = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocalB = new ThreadLocal<>();

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                threadLocalA.set("t1");
                threadLocalB.set(1);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("t1内threadLocalA.get()=" + threadLocalA.get());
                System.out.println("t1内threadLocalB.get()=" + threadLocalB.get());
            }
        };

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                threadLocalA.set("t2");
                threadLocalB.set(2);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("t2内threadLocalA.get()=" + threadLocalA.get());
                System.out.println("t2内threadLocalB.get()=" + threadLocalB.get());
            }
        };

        t1.start();
        t2.start();
    }

}
