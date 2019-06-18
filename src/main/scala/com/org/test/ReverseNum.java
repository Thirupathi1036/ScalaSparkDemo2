package com.org.test;

public class ReverseNum {


    public static void main(String[] s) {

        int num = 123;
        int sum = 0, rem = 0;

        while (num > 0) {
            rem = num % 10;
            //sum = sum + (rem * 10);
            sum = (sum *10)+rem;
            num = num / 10;
        }

        System.out.println(sum);
    }
    ReverseNum(String em){

    }
}
