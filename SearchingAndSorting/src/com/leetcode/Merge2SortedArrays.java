package com.leetcode;

import java.util.Arrays;

public class Merge2SortedArrays {

    static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    static void merge(int[] a1, int[] a2, int l1, int l2) {

        int i, j, gap = l1 + l2;

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            for (i = 0; i + gap < l1; i++) {
                if (a1[i] > a1[i + gap]) {
                    int temp = a1[i];
                    a1[i] = a1[i + gap];
                    a1[i + gap] = temp;
                }
            }

            for (j = gap > l1 ? gap - l1 : 0; i < l1 && j < l2; i++, j++) {
                if (a1[i] > a2[j]) {
                    int temp = a1[i];
                    a1[i] = a2[j];
                    a2[j] = temp;
                }
            }

            if (j < l2) {
                for (j = 0; j + gap < l2; j++)
                    if (a2[j] > a2[j + gap]) {
                        int temp = a2[j];
                        a2[j] = a2[j + gap];
                        a2[j + gap] = temp;
                    }
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {10, 27, 38, 43, 82};
        int[] a2 = {3, 9};

        merge(a1, a2, a1.length, a2.length);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
}
