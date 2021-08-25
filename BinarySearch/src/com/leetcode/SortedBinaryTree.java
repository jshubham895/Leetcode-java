package com.leetcode;

public class SortedBinaryTree {
    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        System.out.println(findPivot(a));
    }

    static int findPivot(int[] a) {
        int start = 0, end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && a[mid] > a[mid + 1])
                return mid;
            else if (mid > start && a[mid] < a[mid-1])
                return mid - 1;
            else if (a[mid] <= a[start])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}
