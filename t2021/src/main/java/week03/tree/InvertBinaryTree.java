package week03.tree;

import common.model.TreeNode;

/**
 * leetcode: https://leetcode-cn.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        // TODO: 打印树形结构
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
