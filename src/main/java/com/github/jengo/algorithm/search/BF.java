package com.github.jengo.algorithm.search;

/**
 * {@link BF} Brute-Force
 *
 * https://mp.weixin.qq.com/s/Z1ehFKIVd07UCqjtTXDY2w
 */
public class BF {

    public static int index(String s, String t) {
        int i = 0;  // i 表示主串 s 中当前位置下标
        int j = 0;  // j 表示子串 t 中当前位置下标

        while (i < s.length() && j < t.length()) { // i 或 j 其中一个到达尾部则终止搜索
            if (s.charAt(i) == t.charAt(j)) {      // 若相等则继续进行下一个元素匹配
                i++;
                j++;
            } else {           // 若匹配失败则 j 回溯到第一个元素重新匹配
                i = i - j + 1; // 将 i 重新回溯到上次匹配首位的下一个元素
                j = 0;
            }
        }

        if (j == t.length()) {
            return i - t.length() + 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String p = "jengowang";
        String s = "owa";
        int i = index(p, s);
        System.out.println(i);
    }

}
