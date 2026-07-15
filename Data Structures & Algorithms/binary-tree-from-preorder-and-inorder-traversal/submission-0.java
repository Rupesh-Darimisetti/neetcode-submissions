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
    /**Algorithm
     * 1. Create a dummy head node and set curr to point to it.
     * 2. Iterate through preorder with index i and inorder with index j.
     * 3. Create a new node for preorder[i] and attach it as curr's right child,
     *    then move curr to this new node.
     * 4. While preorder[i] does not match inorder[j], keep creating left children
     *    (storing parent in right pointer).
     * 5. When a match is found, increment j. While curr.right exists and matches
     *    inorder[j], clear the temporary right link and move up.
     * 6. Continue until all nodes are processed.
     * 7. Return head.right as the actual root.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(0);
        TreeNode curr = head;
        int i = 0, j = 0, n = preorder.length;

        while (i < n && j < n) {
            curr.right = new TreeNode(preorder[i], null, curr.right);
            curr = curr.right;
            i++;
            while (i < n && curr.val != inorder[j]) {
                curr.left = new TreeNode(preorder[i], null, curr);
                curr = curr.left;
                i++;
            }
            j++;
            while (curr.right != null && j < n && curr.right.val == inorder[j]) {
                TreeNode prev = curr.right;
                curr.right = null;
                curr = prev;
                j++;
            }
        }
        return head.right;
    }
}
