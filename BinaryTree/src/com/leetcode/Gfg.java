package com.leetcode;

// Java program to find the lexicographically
// maximum substring.

class Gfg {

    static String LexicographicalMaxString(String str)
    {
        // loop to find the max leicographic
        // substring in the substring array
        String mx = "";
        for (int i = 0; i < str.length(); ++i) {
            String s = str.substring(i);
            if (mx.compareTo(s) <= 0) {
                mx = s;
            }
        }

        return mx;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "ababaa";
        System.out.println(LexicographicalMaxString(str));
    }
}
// This code is contributed by 29AjayKumar

