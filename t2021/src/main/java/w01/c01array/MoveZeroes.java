package w01.c01array;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public static void main(String[] args) {
        Solution01.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public static class Solution01 {
        public static void moveZeroes(int[] nums) {
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[n] = nums[i];
                    n++;
                }
            }
            while (n < nums.length) {
                nums[n] = 0;
                n++;
            }
            Print.arr(nums);
        }
    }

}
