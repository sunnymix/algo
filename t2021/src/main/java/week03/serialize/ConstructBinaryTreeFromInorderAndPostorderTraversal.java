package week03.serialize;

import common.model.TreeNode;

/**
 * leetcode: https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private int[] postorder;
    private int[] inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        return _build(0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode _build(int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight) {
            return null;
        }
        // 后序末位即是根：
        TreeNode root = new TreeNode(postorder[postRight]);
        // 中序根的位置：
        int inMid = inLeft;
        while (inorder[inMid] != root.val) {
            inMid++;
        }
        // 左子树的长度：
        int leftLen = inMid - inLeft;
        // 通过中序根：定位中序的左右子树的位置
        // 通过左子树长度：定位后序的左右子树的位置
        root.left = _build(postLeft, postLeft + leftLen - 1, inLeft, inMid - 1);
        root.right = _build(postLeft + leftLen, postRight - 1, inMid + 1, inRight);
        return root;
    }
}
