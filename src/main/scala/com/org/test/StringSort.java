package com.org.test;

import java.util.Arrays;

public class StringSort {
    public static void main(String[] a) {
        String str = "cvabc";
        System.out.println(sortString(str));
    }

    public static String sortString(String str) {
        char[] ab = str.toCharArray();
        for (int i = 0; i < ab.length; i++) {
            for (int j = i; j < ab.length; j++) {
                if (ab[i] > ab[j]) {
                    char tmp = ab[i];
                    ab[i] = ab[j];
                    ab[j] = tmp;
                }
            }
        }
        return new String(ab);
    }

}
