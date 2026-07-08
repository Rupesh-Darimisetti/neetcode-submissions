/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private String serialize(TreeNode root) {
        if (root == null) {
            return "$#";
        }
        return "$" + root.val + serialize(root.left) + serialize(root.right);
    }

    private int[] z_function(String s) {
        int left = 0, right = 0, n = s.length();
        int[] z = new int[n];
        for (int pos = 1; pos < n; pos++) {
            if (pos <= right) {
                z[pos] = Math.min(right - pos + 1, z[pos - left]);
            }
            while (pos + z[pos] < n && s.charAt(z[pos]) == s.charAt(pos + z[pos])) {
                z[pos]++;
            }
            if (pos + z[pos] - 1 > right) {
                left = pos;
                right = pos + z[pos] - 1;
            }
        }
        return z;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String serialized_root = serialize(root);
        String serialized_subRoot = serialize(subRoot);
        String combined = serialized_subRoot + "|" + serialized_root;

        int[] z_values = z_function(combined);
        int sub_len = serialized_subRoot.length();

        for (int pos = sub_len + 1; pos < combined.length(); pos++) {
            if (z_values[pos] == sub_len) {
                return true;
            }
        }
        return false;
    }
}
