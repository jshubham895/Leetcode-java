package com.leetcode;

public class FirstAndLastPos {
    public static void main(String[] args) {
        int[] a = {1,2,2,2,3,4,5};
        int first = search(a,2,true);
        int last = search(a,2,false);
        System.out.println(first);
        System.out.println(last);
    }

    static int search(int[] a, int target, boolean firstIndex) {
        int start = 0;
        int end = a.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == target) {
                res = mid;
                if (firstIndex)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else if (target > a[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return res;
    }
}
