package com.leetcode;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int ans = binarySearch(a,2,0,a.length-1);
        System.out.println(ans);
    }

    public static int binarySearch(int[] a, int target, int start, int end){

        while(start <= end){
            int mid = start + (end - start)/2;

            if (a[mid] == target)
                return mid;
            else if(target > a[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }
}
