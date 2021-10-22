package week03.recursion;

import common.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {
    public static void main(String[] args) {
        Print.line(new Combinations().combine(4, 2));
    }

    private int n, k;
    private final Stack<Integer> chosen = new Stack<>();
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        _recur(1);
        return res;
    }

    private void _recur(int i) {
        // 剪枝
        if (chosen.size() > k || (chosen.size() + (n - i + 1)) < k) {
            return;
        }
        // 递归边界
        if (i == n + 1) {
            res.add(new ArrayList<>(chosen));
            return;
        }
        // 不选
        _recur(i + 1);
        // 选
        chosen.push(i);
        _recur(i + 1);
        // 还原现场
        chosen.pop();
    }
}
