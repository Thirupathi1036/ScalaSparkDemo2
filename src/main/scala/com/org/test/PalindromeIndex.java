package com.org.test;

import java.util.Scanner;

public class PalindromeIndex {
    public static void main(String[] a) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Enter " + n + " Strings:");
        for (int i = 0; i < n; i++) {
            String str = in.next();
            System.out.println(findRemoveIndex(str));
        }
    }

    static int findRemoveIndex(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return isPalindrome(str, i + 1, j) ? i : j;
            }
        }
        return -1;
    }

    static boolean isPalindrome(String str, int bi, int ei) {
        for (int i = bi, j = ei; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
