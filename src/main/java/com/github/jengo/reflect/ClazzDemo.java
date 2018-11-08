package com.github.jengo.reflect;

/**
 * test class loading
 *
 * https://mp.weixin.qq.com/s/qSrzpgfkyJsLQrunxrIRHw
 */
public class ClazzDemo {

    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> integerClass = int.class;
        integerClass = Integer.class;
        intClass = double.class;
        //integerClass = double.class;
        Class<?> intClass2 = int.class;
        intClass2 = double.class;
        //Class<Number> numberClass=Integer.class;
        Class<? extends Number> clazz = Integer.class;
        clazz = double.class;
        clazz = Number.class;
    }

}
