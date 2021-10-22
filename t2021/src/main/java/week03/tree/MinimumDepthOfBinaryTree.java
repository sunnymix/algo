package week03.tree;

import common.model.TreeNode;

/**
 * leetcode: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        // TODO
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        return (leftMin == 0 || rightMin == 0) ?
                leftMin + rightMin + 1 :
                Math.min(leftMin, rightMin);
    }
}
