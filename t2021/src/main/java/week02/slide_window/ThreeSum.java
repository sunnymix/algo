package week02.slide_window;

import common.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode: https://u.geekbang.org/lesson/186?article=419931
 */
public class ThreeSum {
    public static void main(String[] args) {
        Print.line(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> jks = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> jk : jks) {
                res.add(Arrays.asList(nums[i], jk.get(0), jk.get(1)));
            }
        }
        return res;
    }

    static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int j = nums.length - 1;
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            while (i < j && (nums[i] + nums[j]) > target) j--;
            if (i < j && (nums[i] + nums[j]) == target) {
                res.add(Arrays.asList(nums[i], nums[j]));
            }
        }
        return res;
    }
}
