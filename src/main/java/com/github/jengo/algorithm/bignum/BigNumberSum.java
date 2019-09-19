package com.github.jengo.algorithm.bignum;

/**
 * {@link BigNumberSum}
 * 如何实现大整数相加：https://mp.weixin.qq.com/s/Quw4olmTYEE4qLCupld91A
 */
public class BigNumberSum {

    public static void main(String[] args) {
        String bigNumberA = "426709752318";
        String bigNumberB = "95481253129";
        String result = bigNumberSum(bigNumberA, bigNumberB);
        System.out.println(result);
    }

    /**
     * 大整数求和
     *
     * @param bigNumberA 大整数A
     * @param bigNumberB 大整数B
     *
     * @return 大整数求和结果
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        //1.把两个大整数用数组逆序存储
        char[] charsA = new StringBuilder(bigNumberA).reverse().toString().toCharArray();
        char[] charsB = new StringBuilder(bigNumberB).reverse().toString().toCharArray();
        //2.构建result数组，数组长度等于较大整数位数+1
        int maxLen = charsA.length > charsB.length ? charsA.length : charsB.length;
        int[] result = new int[maxLen];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int tmp = result[i];
            if (i < charsA.length) {
                tmp += charsA[i] - '0';
            }
            if (i < charsB.length) {
                tmp += charsB[i] - '0';
            }
            //判断是否进位
            if (tmp >= 10) {
                tmp -= 10;
                result[i + 1] = 1;
            }
            result[i] = tmp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            }
            flag = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
