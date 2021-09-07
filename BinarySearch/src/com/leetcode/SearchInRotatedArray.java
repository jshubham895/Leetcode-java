package com.leetcode;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(a, 0));
    }

    static int search(int[] nums, int target) {
        int pivot = findPeakWithDuplicates(nums);
        if (pivot == -1)
            return binarySearch(nums, target, 0, nums.length - 1);

        if (nums[pivot] == target)
            return pivot;

        if (target >= nums[0])
            return binarySearch(nums, target, 0, pivot);

        return binarySearch(nums, target, pivot + 1, nums.length - 1);

    }

    public static int binarySearch(int[] a, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] == target)
                return mid;
            else if (target > a[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    // does not work with duplicate values
    static int findPivot(int[] a) {
        int start = 0, end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && a[mid] > a[mid + 1])
                return mid;
            if (mid > start && a[mid] < a[mid - 1])
                return mid - 1;
            if (a[mid] <= a[start])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }

    // work with duplicate values
    static int findPeakWithDuplicates(int[] a) {
        int start = 0, end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && a[mid] > a[mid + 1])
                return mid;
            if (mid > start && a[mid] < a[mid - 1])
                return mid - 1;

            // if elements at start and end are duplicates then just skip them
            if (a[mid] == a[start] && a[mid] == a[start]) {
                if (a[start] > a[start + 1])
                    return start;
                start++;

                if (a[end] < a[end - 1])
                    return end - 1;
                end--;
            } else if (a[start] < a[mid] || a[start] == a[mid] && a[mid] > a[start])
                start = mid + 1;
            else
                end = mid - 1;

        }

        return -1;
    }
}
