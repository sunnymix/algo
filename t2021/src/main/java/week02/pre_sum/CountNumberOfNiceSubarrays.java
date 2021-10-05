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
        return -100000;
    }
}
