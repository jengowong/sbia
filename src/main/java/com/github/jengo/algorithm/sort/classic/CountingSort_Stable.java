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
public class CountingSort_Stable {

    public static int[] countingSort(int[] arr) {
        if (ArrayUtils.isEmpty(arr) || arr.length < 2) {
            return arr;
        }
        //1.得到数列的最大值和最小值，并算出差值d
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
            if (min > a) {
                min = a;
            }
        }
        int d = max - min;
        //2.创建统计数组并统计对应元素个数
        int[] bucket = new int[d + 1];
        for (int a : arr) {
            bucket[a - min]++;
        }
        //3.统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = bucket[i] + bucket[i - 1];
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[bucket[arr[i] - min] - 1] = arr[i];
            bucket[arr[i] - min]--;
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{90, 99, 95, 94, 95};
        ArrayUtil.print(arr);
        long begMillis = System.currentTimeMillis();
        int[] sortedArr = countingSort(arr);
        long endMillis = System.currentTimeMillis();
        ArrayUtil.print(sortedArr);
        System.out.println("sorting consumed " + (endMillis - begMillis) + " ms");
    }

}
