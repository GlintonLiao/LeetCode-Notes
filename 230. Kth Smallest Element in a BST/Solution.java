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
    int result = 0;
    int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return result;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
            
        traverse(root.left);
        
        // in-order traversal
        count -= 1;
        if (count == 0) {
            result = root.val;
            return;
        }
        
        traverse(root.right);
    }
}
