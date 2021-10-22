package week03.recursion;

import common.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        Print.line(new Permutations().permute(new int[]{1, 2, 3}));
    }

    private int n;
    private boolean[] used;
    private final Stack<Integer> arrange = new Stack<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.used = new boolean[this.n];
        _recur(nums, 0);
        return res;
    }

    private void _recur(int[] nums, int pos) {
        // 边界
        if (pos == n) {
            res.add(new ArrayList<>(arrange));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                // 选
                arrange.push(nums[i]);
                used[i] = true;
                _recur(nums, pos + 1);
                // 还原现场
                arrange.pop();
                used[i] = false;
            }
        }
    }
}
