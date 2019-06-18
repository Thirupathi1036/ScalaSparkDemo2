package com.org.test;

import java.util.ArrayList;
import java.util.List;

public class Test33 {
    public  static void main(String[] ar){
        int A=103;
        Integer AA=new Integer(A);
        String str=AA.toString();
        System.out.println(str);
        char[] aaa=str.toCharArray();
        String res="";
        int i=0;
        int j=str.length()-1;
        while(i<=j){
            if(i==j){
                res=res+str.charAt(i);
                break;
            }
            res=res+str.charAt(i);
            i=i+1;
            res=res+str.charAt(j);
            j=j-1;
        }

        int nn=Integer.parseInt(res);
        System.out.println(nn);

    }
}
