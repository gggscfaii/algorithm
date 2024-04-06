package com.wsd.algorithm.leetcode.interview;

public class A209长度最小的子数组 {

    public static int minSubArrayLen(int target, int[] nums) {

        int dp[] = new int[nums.length];
        int dpIndex[] = new int[nums.length];

        dp[0] = nums[0];
        dpIndex[0] = 0;
        for (int i = 1; i < nums.length; i++) {

            int sum = dp[i - 1] + nums[i];
            int index = dpIndex[i - 1];
            while (index < i && sum >= target) {
                if (sum - nums[index] < target) {
                    break;
                }
                sum -= nums[index++];
            }

            dpIndex[i] = index;
            dp[i] = sum;
        }

        int minLength = -1;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] < target) {
                continue;
            }

            int len = i - dpIndex[i] + 1;
            if (minLength == -1) {
                minLength = len;
                continue;
            }
            minLength = Math.min(len, minLength);
        }
        return minLength < 0 ? 0 : minLength;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
