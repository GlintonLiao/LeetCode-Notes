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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return traverse(0, root);
    }
    
    private int traverse(int sum, TreeNode root) {
        if (root == null) return 0;
        
        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            int left = traverse(sum, root.left);
            int right = traverse(sum, root.right);
            return left + right;
        }
    }
}
