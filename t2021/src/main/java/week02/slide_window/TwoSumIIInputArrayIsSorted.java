package week02.slide_window;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        Print.array(twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    static int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            while (i < j && (numbers[j] + numbers[i]) > target) {
                j--;
            }
            if (i < j && (numbers[j] + numbers[i]) == target) {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }
}
