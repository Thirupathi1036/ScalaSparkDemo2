package com.org.java.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;


public class FindMissNum {
    public static void main(String[] a) {

        //test();
        squareRoot(6000,7000);
    }
    public static void test(){

        for(int i=3;i<=30;++i){
            if(i%7!=0)
                continue;
            if(i%14==0)
                System.out.println(i);
        }
    }

    static int squareRoot(int a,int b){
        int res=0;
        List<Double> list=new ArrayList<Double>();
        for(int i=a;i<=b;i++){
            double val=Math.sqrt(i);

            if(checkNum(val)){
                list.add(val);
            }
            System.out.println(list);
        }
        return res;
    }
    static boolean checkNum(double a){
        boolean flag= false;
        String str=String.valueOf(a);
       // System.out.println(str);
        String ab=str.split("\\.")[1];
        if(Long.parseLong(ab)==0L) flag=true;
        return flag;
    }


}
