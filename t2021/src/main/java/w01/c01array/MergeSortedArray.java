package w01.c01array;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        Solution01.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        Solution02.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    /**
     * 正着合并，从小到大，额外的数组存放结果
     */
    public static class Solution01 {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] results = new int[m + n];
            int i = 0, j = 0, cnt = 0;
            while (i < m || j < n) {
                // 什么时候要nums1[i]？或者j出界；或者i,j都没有出界，要小的。
                if (j >= n || (i < m && nums1[i] <= nums2[j])) {
                    results[cnt] = nums1[i];
                    i++;
                } else {
                    results[cnt] = nums2[j];
                    j++;
                }
                cnt++;
            }
            for (int x = 0; x < m + n; x++) {
                nums1[x] = results[x];
            }
            Print.array(results);
        }
    }

    /**
     * 倒着合并，从大到小，在nums1中存放结果
     */
    public static class Solution02 {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            for (int k = m + n - 1; k >= 0; k--) {
                // 什么时候要nums1[i]？或者j出界；或者i,j都没有出界，要大的
                if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
            }
            Print.array(nums1);
        }
    }

}
