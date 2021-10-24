package week03.serialize;

import common.model.TreeNode;

/**
 * leetcode: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        // TODO
    }

    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return _build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode _build(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inMid = inLeft;
        while (inorder[inMid] != root.val) {
            inMid++;
        }
        root.left = _build(preLeft + 1, preLeft + (inMid - inLeft), inLeft, inMid - 1);
        root.right = _build(preLeft + (inMid - inLeft) + 1, preRight, inMid + 1, inRight);
        return root;
    }
}
