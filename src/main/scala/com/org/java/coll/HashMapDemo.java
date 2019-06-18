package com.org.java.coll;

import java.util.Map;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] a) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("aa", 11);
        map.put("bbv", 33);
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        map.clear();
        System.out.println("after clear");
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        int int_hash = hash(123);
        System.out.println(int_hash);
        int str_hash = hash("Abc");
        int str_hash1 = hash("abc");
        System.out.println(str_hash);
        System.out.println(str_hash1);

        int hh = "abc".hashCode();
        int hexa = hh >>> 16;
        System.out.println(hh);
        System.out.println(hexa);
        getCode();

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int getCode() {
        char[] value = "abc".toCharArray();
        int hash = 0;
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                int hv = h;
                int vv = val[i];
                h = 31 * hv + vv;
            }
            hash = h;
        }
        return h;
    }
}
