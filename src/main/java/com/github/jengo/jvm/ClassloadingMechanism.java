package com.github.jengo.jvm;

/**
 * {@link ClassloadingMechanism}
 *
 * https://blog.csdn.net/linxdcn/article/details/73555233
 */
public class ClassloadingMechanism {

    public static int a = 1;

    static {
        System.out.println("initialized");
    }

    public int b = 2;

    {
        System.out.println("instantiated_1");
    }

    public ClassloadingMechanism() {
        System.out.println("instantiated_2");
    }

    public static void main(String[] args) {
        ClassloadingMechanism classloadingMechanism = new ClassloadingMechanism();
    }

}
