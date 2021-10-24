package week03.transform;

import common.model.TreeNode;

/**
 * leetcode: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        _dfs(root);
        return ans;
    }

    private static class HasPAndQ {
        boolean hasP, hasQ;

        HasPAndQ(boolean hasP, boolean hasQ) {
            this.hasP = hasP;
            this.hasQ = hasQ;
        }
    }

    private TreeNode p;
    private TreeNode q;
    private TreeNode ans;

    private HasPAndQ _dfs(TreeNode root) {
        if (root == null) {
            return new HasPAndQ(false, false);
        }
        HasPAndQ leftResult = _dfs(root.left);
        HasPAndQ rightResult = _dfs(root.right);
        HasPAndQ result = new HasPAndQ(false, false);
        result.hasP = leftResult.hasP || rightResult.hasP || root.val == p.val;
        result.hasQ = leftResult.hasQ || rightResult.hasQ || root.val == q.val;
        if (result.hasP && result.hasQ && ans == null) {
            ans = root;
        }
        return result;
    }
}
