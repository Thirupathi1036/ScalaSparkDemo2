package com.org.test;

public class CharToString {
    public static void main(String[] ar){
        char[] c=new char[2];
        c[0]='a';
        c[1]='b';

        String str=new String(c);
        System.out.println(str);
        char ca='a';

        String sc=String.valueOf(ca);
        System.out.println(sc);

        String cs=Character.toString(ca);
        System.out.println(sc);
    }
}
