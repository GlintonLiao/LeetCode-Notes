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
    boolean result = false;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return result;
    }
    
    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        
        if (root.val == targetSum) {
            if (root.left == null && root.right == null) {
                result = true;
            }
        }
        
        traverse(root.left, targetSum - root.val);
        traverse(root.right, targetSum - root.val);
    }
}
