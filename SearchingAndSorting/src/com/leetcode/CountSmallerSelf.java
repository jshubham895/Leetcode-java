package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class CountSmallerSelf {

    public static class ArrayWithOrignalIndex {
        int val;
        int orignalIndex;

        public ArrayWithOrignalIndex(int val, int orignalIndex) {
            this.val = val;
            this.orignalIndex = orignalIndex;
        }
    }

    public static List<Integer> countSmaller(int[] a) {
        if (a == null || a.length == 0)
            return new LinkedList<>();

        int n = a.length;
        int[] result = new int[n];

        ArrayWithOrignalIndex[] newNums = new ArrayWithOrignalIndex[n];
        for (int i = 0; i < n; ++i) {
            newNums[i] = new ArrayWithOrignalIndex(a[i], i);
        }

        mergeSortAndCount(newNums, 0, n - 1, result);

        List<Integer> resultList = new LinkedList<>();
        for (int i : result)
            resultList.add(i);

        return resultList;
    }

    public static void mergeSortAndCount(ArrayWithOrignalIndex[] nums, int start, int end, int[] result){
        if (start >= end)
            return;

        int mid = start + (end - start)/2;
        mergeSortAndCount(nums,start,mid,result);
        mergeSortAndCount(nums,mid+1,end,result);

        int leftPos = start;
        int rightPos = mid+1;

        LinkedList<ArrayWithOrignalIndex> merged = new LinkedList<>();
        int numElemsRightArrayLessThanLeftArray = 0;
        while(leftPos < mid +1 && rightPos <= end){
            if (nums[leftPos].val > nums[rightPos].val){
                ++numElemsRightArrayLessThanLeftArray;
                merged.add(nums[rightPos]);
                ++rightPos;
            }
            else{
                result[nums[leftPos].orignalIndex] += numElemsRightArrayLessThanLeftArray;
                merged.add(nums[leftPos]);
                ++leftPos;
            }
        }

        while(leftPos < mid+1){
            result[nums[leftPos].orignalIndex] += numElemsRightArrayLessThanLeftArray;
            merged.add(nums[leftPos]);
            ++leftPos;
        }

        while(rightPos <= end){
            merged.add(nums[rightPos]);
            ++rightPos;
        }

        int pos = start;
        for (ArrayWithOrignalIndex m : merged){
            nums[pos] = m;
            ++pos;
        }
    }

    public static void main(String[] args) {
        int[] a = {5,2,6,1};
        System.out.println(countSmaller(a));

    }
}
