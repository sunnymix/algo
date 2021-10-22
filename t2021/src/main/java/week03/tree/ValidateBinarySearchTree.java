package week03.tree;

import common.model.TreeNode;

/**
 * leetcode: https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 注意，使用更大的值来防止越界
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        // TODO：快速表达和构建一棵树
    }

    public boolean isValidBST(TreeNode root) {
        return _check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean _check(TreeNode root, long rangeLeft, long rangeRight) {
        if (root == null) {
            return true;
        }
        if (root.val < rangeLeft || root.val > rangeRight) {
            return false;
        }
        return _check(root.left, rangeLeft, (long) root.val - 1) &&
                _check(root.right, (long) root.val + 1, rangeRight);
    }
}
