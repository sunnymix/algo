package week03.recursion;

import common.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {
    public static void main(String[] args) {
        Print.line(new Subsets().subsets(new int[]{1, 2, 3}));
    }

    int n;
    private final Stack<Integer> chosen = new Stack<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.n = nums.length;
        _recur(nums, 0);
        return res;
    }

    private void _recur(int[] nums, int i) {
        if (i == n) {
            res.add(new ArrayList<>(chosen));
            return;
        }
        _recur(nums, i + 1);
        chosen.push(nums[i]);
        _recur(nums, i + 1);
        chosen.pop();
    }
}
