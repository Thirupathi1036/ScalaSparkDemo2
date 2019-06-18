package com.org.test;

public class ReverseArray {
    public static void main(String[] a) {
        String str1 = "12345";
        char[] c1=str1.toCharArray();
        char[] c2=c1;
        for(int i=0,j=c2.length,mid=c1.length/2;i<mid;i++,j--){
            char tmp=c1[i];
            c1[i]=c2[j-1];
            c2[j-1]=tmp;
        }
        for(char v:c1){
            System.out.println(v);
        }
    }
}