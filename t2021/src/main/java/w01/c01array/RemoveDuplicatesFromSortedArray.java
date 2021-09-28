package w01.c01array;

/**
 * leetcode: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 4, 4, 5};
        int result = Solution01.removeDuplicates(nums);
        System.out.printf("Result is: %s", result);
    }

    public static class Solution01 {
        public static int removeDuplicates(int[] nums) {
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    nums[n] = nums[i];
                    n++;
                }
            }
            return n;
        }
    }

}
