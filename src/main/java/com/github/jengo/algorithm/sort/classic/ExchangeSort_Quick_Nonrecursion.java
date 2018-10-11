package com.github.jengo.algorithm.sort.classic;

import java.util.Stack;

/**
 * 交换排序(2)-->快速排序(非递归)
 */
public class ExchangeSort_Quick_Nonrecursion {

    private static int partition(int[] arr, int idxBeg, int idxEnd) {
        int idxL = idxBeg;
        int idxR = idxEnd;
        int valPivot = arr[idxL];

        if (idxBeg < idxEnd) {
            while (idxL < idxR) {
                while (idxL < idxR && arr[idxR] <= valPivot) {
                    idxR--;
                }
                if (idxL < idxR) {
                    arr[idxL] = arr[idxR];
                    idxL++;
                }
                while (idxL < idxR && arr[idxL] > valPivot) {
                    idxL++;
                }
                if (idxL < idxR) {
                    arr[idxR] = arr[idxL];
                    idxR--;
                }
            }
            arr[idxL] = valPivot;
        }
        return idxL;
    }

    public static void sort(int[] arr) {
        if (null != arr && arr.length > 1) {
            //存放开始与结束索引
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(0);
            stack.push(arr.length - 1);
            //利用循环实现
            while (!stack.empty()) {
                int idxRight = stack.pop();
                int idxLeft = stack.pop();
                //如果最大索引小于等于左边索引，说明结束了
                if (idxRight > idxLeft) {
                    int idxPivot = partition(arr, idxLeft, idxRight);
                    if (idxLeft < idxPivot - 1) {
                        stack.push(idxLeft);
                        stack.push(idxPivot - 1);
                    }
                    if (idxPivot + 1 < idxRight) {
                        stack.push(idxPivot + 1);
                        stack.push(idxRight);
                    }
                }
            }
        }
    }

    @Deprecated
    public static void main(String[] args) {
        //int[] arr = {8, 16, 29, 37, 44, 44, 49, 52, 57, 59, 68};
        int[] arr = new int[]{2, 3, 8, 7, 1, 2, 2, 2, 7, 3, 9, 8, 2, 1, 4, 2, 4, 6, 9, 2};
        ArrayUtil.print(arr);
        long begMillis = System.currentTimeMillis();
        sort(arr);
        long endMillis = System.currentTimeMillis();
        ArrayUtil.print(arr);
        System.out.println("sorting consumed " + (endMillis - begMillis) + " ms");
    }

}
