package week02.pre_sum;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Print.line(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int res = -100000;
        int n = nums.length;
        int[] s = new int[n + 1];
        int[] preMin = new int[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        for (int i = 1; i <= n; i++) preMin[i] = Math.min(preMin[i - 1], s[i]);
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, s[i] - preMin[i - 1]);
        }
        return res;
    }
}
