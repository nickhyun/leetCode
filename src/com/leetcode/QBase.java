package com.leetcode;

public class QBase {

    public static void log(Object s) {

        if(s instanceof int[]) {
            int[] arr = (int[])s;
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        System.out.println(s);

    }
}
