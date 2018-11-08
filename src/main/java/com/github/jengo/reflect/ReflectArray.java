package com.github.jengo.reflect;

import java.lang.reflect.Array;

/**
 * test class loading
 *
 * https://mp.weixin.qq.com/s/qSrzpgfkyJsLQrunxrIRHw
 */
public class ReflectArray {
    public static void main(String[] args) throws ClassNotFoundException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Class<?> clazz = array.getClass().getComponentType();

        Object newArr = Array.newInstance(clazz, 15);

        int co = Array.getLength(array);

        System.arraycopy(array, 0, newArr, 0, co);
        for (int i : (int[]) newArr) {
            System.out.print(i + ",");
        }

        Class clazz2 = Class.forName("java.lang.String");
        Object array2 = Array.newInstance(clazz2, 10);
        Array.set(array2, 6, "hello world!");

        String str = (String) Array.get(array2, 6);
        System.out.println();
        System.out.println(str);
    }

    /**
     * 接收一个泛型数组，然后创建一个长度与接收的数组长度一样的泛型数组，
     * 并把接收的数组的元素复制到新创建的数组中，
     * 最后找出新数组中的最小元素，并打印出来
     *
     * @param a
     * @param <T>
     */
    public <T extends Comparable<T>> void min(T[] a) {

        T[] b = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        T min = null;
        boolean flag = true;
        for (int i = 0; i < b.length; i++) {
            if (flag) {
                min = b[i];
                flag = false;
            }
            if (b[i].compareTo(min) < 0) {
                min = b[i];
            }
        }
        System.out.println(min);
    }
}
