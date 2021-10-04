package week01.array;

/**
 * leetcode: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(Solution01.removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 5}));
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
