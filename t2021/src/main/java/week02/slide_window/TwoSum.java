package week02.slide_window;

import common.Print;

import java.util.Arrays;

/**
 * leetcode: https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        Print.array(twoSum(new int[]{3, 2, 4}, 6)); // 1, 2
        Print.array(twoSum(new int[]{2, 7, 11, 15}, 9)); // 0, 1
        Print.array(twoSum(new int[]{3, 3}, 6)); // 0, 1
    }

    public static int[] twoSum(int[] nums, int target) {
        // FIXME: keep the index
        Arrays.sort(nums);
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i < j && (nums[j] + nums[i]) > target) {
                j--;
            }
            if (i < j && (nums[j] + nums[i]) == target) {
                return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
