package com.github.jengo.algorithm.sort.classic;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 线性时间非比较类排序--基数排序
 * <pre/>
 *
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
 * 有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
 * 最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。
 *
 * 算法描述：
 * (1)取得数组中的最大数，并取得位数；
 * (2)arr为原始数组，从最低位开始取每个位组成radix数组；
 * (3)对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 *
 * 算法性能分析：
 * 这个算法还是比较有想法的。
 * 基数排序的时间复杂度为O(nlog(r)m)，r为位数，m为基数。
 */
public class RadixSort {
    private static final Logger LOG = LoggerFactory.getLogger(RadixSort.class);

    public static int[] radixSort(int[] arr) {
        //找到最大数 确定要排序几趟
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        //判断有几位
        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;
        }

        //建立十个桶
        List<ArrayList> buckets = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList());
        }

        //将相应的数放在相应的桶中
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < arr.length; j++) {
                int x = arr[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList temp = buckets.get(x);
                temp.add(arr[j]);
                buckets.set(x, temp);
            }

            //收集
            int count = 0;
            for (int k = 0; k < 10; k++) {
                while (buckets.get(k).size() > 0) {
                    ArrayList<Integer> result = buckets.get(k);
                    arr[count] = result.get(0);
                    result.remove(0);
                    count++;
                }
            }
        }
        return arr;
    }

    @Deprecated
    public static void main(String[] args) {
        int[] unsortedArr = new int[]{57, 68, 59, 52, 44, 49, 29, 37, 8, 16};
        int[] sortedArr = radixSort(unsortedArr);
        LOG.info("descendingArr={}", sortedArr);
    }

}
