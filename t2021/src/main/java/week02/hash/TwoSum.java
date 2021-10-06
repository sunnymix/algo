package week02.hash;

import common.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 * 两数之和为 target，枚举 i，在 i 之前的集合中找 j = target - i。
 * <p>
 * target: 6
 * nums: { 3, 2, 4 }
 * map: { 3: 0, 2: 1, 4: 2 }
 */
public class TwoSum {
    public static void main(String[] args) {
        Print.array(twoSum(new int[]{3, 2, 4}, 6));
        Print.array(twoSum(new int[]{2, 7, 11, 15}, 9));
        Print.array(twoSum(new int[]{3, 3}, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> pre = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer p = pre.get(target - nums[i]);
            if (p != null) {
                res[0] = p;
                res[1] = i;
                return res;
            } else {
                pre.put(nums[i], i);
            }
        }
        return res;
    }
}
