package com.github.jengo.javabasicintroduction.ch10;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * {@link CommonUtils}
 */
public class CommonUtils {

    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static void main(String[] args) {
        System.out.println(md5("qdmmy6"));
    }

}
