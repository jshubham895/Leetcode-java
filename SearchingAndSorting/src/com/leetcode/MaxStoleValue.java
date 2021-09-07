package com.leetcode;

public class MaxStoleValue {

    static int maxLoot(int[] a, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return a[0];
        if (n == 2)
            return Math.max(a[0], a[1]);

        int[] dp = new int[n];

        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max((a[i] + dp[i-2]) , dp[i-1]);
        }

        return dp[n-1];
    }

    static int maxLootConstant(int a[], int n)
    {
        if (n == 0)
            return 0;

        int value1 = a[0];
        if (n == 1)
            return value1;

        int value2 = Math.max(a[0], a[1]);
        if (n == 2)
            return value2;

        // contains maximum stolen value at the end
        int max_val = 0;

        // Fill remaining positions
        for (int i=2; i<n; i++)
        {
            max_val = Math.max(a[i]+value1, value2);
            value1 = value2;
            value2 = max_val;
        }

        return max_val;
    }

    public static void main(String[] args) {
        int[] a = {6,7,1,3,8,2,4};
        int n = a.length;
        System.out.println(maxLoot(a,n));
        System.out.println(maxLootConstant(a,n));
    }
}
