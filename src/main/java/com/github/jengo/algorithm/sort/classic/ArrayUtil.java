package com.github.jengo.algorithm.sort.classic;

/**
 * {@link ArrayUtil}
 */
public class ArrayUtil {

    public static <T> void print(T[] arr) {
        int i = 0;
        for (; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[i]);
        System.out.println();
    }

    public static void print(int[] arr) {
        int i = 0;
        for (; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[i]);
        System.out.println();
    }

}
