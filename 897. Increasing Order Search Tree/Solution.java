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
    TreeNode head = new TreeNode();
    TreeNode p = head;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        p.right = new TreeNode(root.val);
        p = p.right;
        increasingBST(root.right);
        return head.right;
    }
}
