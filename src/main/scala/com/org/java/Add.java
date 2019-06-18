package com.org.java;

import java.util.Random;

public class Add {

    public static void main(String[] args) {
        int res = add(1, 2);
        System.out.println(res);
        Integer n=new Random().nextInt(10);

        System.out.println("Mul:"+(2<<0));
        System.out.println("Mul:"+(2<<1));
        System.out.println("Mul:"+(2<<2));
        System.out.println("Mul:"+(2<<3));

        System.out.println("Div:"+(16>>2));
        System.out.println("Div:"+(16>>2));


    }

    public static int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            return 0;
        } finally {
            return 3;
        }

    }
}
