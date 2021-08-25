package com.leetcode;

public class RotationCount {
    public static void main(String[] args) {
        int[] a = {4,5,6,0,1,2};
        int ans = rotationCount(a) + 1;
        System.out.println(ans);
    }

    public static int rotationCount(int[] a) {
        int start = 0, end = a.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid < end && a[mid] > a[mid + 1])
                return mid;
            if (mid > start && a[mid] < a[mid - 1])
                return mid - 1;

            if (a[mid] == a[start] && a[mid] == a[start]) {
                if (start < end && a[start] > a[start + 1])
                    return start;
                start++;

                if (end > start && a[end] < a[end - 1])
                    return end;
                end--;
            } else if (a[start] < a[mid] || a[start] == a[mid] && a[mid] > a[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
