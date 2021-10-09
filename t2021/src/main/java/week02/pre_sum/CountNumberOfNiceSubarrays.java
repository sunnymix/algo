package week02.pre_sum;

import common.Print;

/**
 * 思路：
 * 1. 解题思路：子段和。
 * 2. 转换问题、简化问题，奇数偶数就是模2等于0或1，恰好有k个奇数，就是前缀和为k。
 * <p>
 * <p>
 * leetcode: https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        Print.line(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int[] s = new int[n + 1]; // 0 ~ n 个位置
        s[0] = 0;
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1] % 2;
        int[] count = new int[n + 1]; // 0 ~ n 个位置
        count[s[0]]++; // s[0] 是一个选项
        for (int i = 1; i <= n; i++) {
            if (s[i] - k >= 0) res += count[s[i] - k]; // 等式：s[i] - s[j] = k，所以：s[j] = s[i] - k
            count[s[i]]++; // s[i] 本身是一个选项
        }
        return res;
    }
}
