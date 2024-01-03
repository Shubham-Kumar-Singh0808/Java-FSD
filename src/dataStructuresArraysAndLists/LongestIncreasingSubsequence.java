package dataStructuresArraysAndLists;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxLIS = 0;
        for (int length : dp) {
            maxLIS = Math.max(maxLIS, length);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int result = longestIncreasingSubsequence(numbers);

        System.out.println("Longest Increasing Subsequence Length: " + result);
    }
}
