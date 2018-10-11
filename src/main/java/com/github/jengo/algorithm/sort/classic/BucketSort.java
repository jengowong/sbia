package com.github.jengo.algorithm.sort.classic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 线性时间非比较类排序--桶排序
 * <pre/>
 *
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 *
 * 桶排序的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，
 * 每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 *
 * 算法描述
 * (1)设置一个定量的数组当作空桶；
 * (2)遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * (3)对每个不是空的桶进行排序；
 * (4)从不是空的桶里把排好序的数据拼接起来。
 */
public class BucketSort {

    public static void bucketSort(int[] arr, int bucketSize) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i]; //输入数据的最小值
            } else if (arr[i] > maxValue) {
                maxValue = arr[i]; //输入数据的最大值
            }
        }

        //桶的初始化
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];

        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        Integer[] a = new Integer[5];
        list.toArray(a);

        //利用映射函数将数据分配到各个桶中

    }

    public static void main(String[] args) {
        int[] arr = new int[]{78, 17, 39, 26, 72, 94, 21, 12, 23, 68};
        ArrayUtil.print(arr);
        bucketSort(arr, 9);
        ArrayUtil.print(arr);
    }

}
