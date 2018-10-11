package com.github.jengo.algorithm.sort.classic;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 线性时间非比较类排序--计数排序
 * <pre/>
 *
 * 计数排序不是基于比较的排序算法，
 * 其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 *
 * 算法描述
 * (1)找出待排序的数组中最大元素；
 * (2)统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * (3)对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * (4)反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {

    public static void countingSort(int[] arr) {
        if (ArrayUtils.isEmpty(arr) || arr.length < 2) {
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
        }

        int[] bucket = new int[max + 1];
        for (int i : arr) {
            bucket[i]++;
        }

        for (int sortedIndex = 0, j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 8, 7, 1, 2, 2, 2, 7, 3, 9, 8, 2, 1, 4, 2, 4, 6, 9, 2};
        ArrayUtil.print(arr);
        long begMillis = System.currentTimeMillis();
        countingSort(arr);
        long endMillis = System.currentTimeMillis();
        ArrayUtil.print(arr);
        System.out.println("sorting consumed " + (endMillis - begMillis) + " ms");
    }

}
