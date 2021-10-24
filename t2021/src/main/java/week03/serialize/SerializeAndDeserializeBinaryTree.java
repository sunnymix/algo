package week03.serialize;

import common.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode: https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        List<String> seq = new ArrayList<>();
        _dfs(seq, root);
        return String.join(",", seq);
    }

    private void _dfs(List<String> seq, TreeNode root) {
        if (root == null) {
            seq.add("null");
            return;
        }
        seq.add(Integer.toString(root.val));
        _dfs(seq, root.left);
        _dfs(seq, root.right);
    }

    public TreeNode deserialize(String data) {
        seq = data.split(",");
        curr = 0;
        return restore();
    }

    private String[] seq;
    int curr;

    private TreeNode restore() {
        if (seq[curr].equals("null")) {
            curr++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(seq[curr]));
        curr++;
        root.left = restore();
        root.right = restore();
        return root;
    }
}
