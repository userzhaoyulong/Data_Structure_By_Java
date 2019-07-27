package com.yulong.recursion;

public class ArrSumRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int sum = sum(arr);
        System.out.println(sum);
    }

    public static int sum(int[] arr){
        return sum(arr, 0);
    }

    public static int sum(int[] arr, int l){
        if (arr.length == l)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }
}
