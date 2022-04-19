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
public class Solution {
    
    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        
        traverse(root);
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void traverse(TreeNode root) {
        
        if (root == null) return;
            
        traverse(root.left);
        
        // If first element has not been found, assign it to prev
        if (n1 == null && prev != null && prev.val >= root.val) {
            n1 = prev;
        }
    
        // If first element is found, assign the second element to the root
        if (n1 != null && prev.val >= root.val) {
            n2 = root;
        }
        
        prev = root;

        traverse(root.right);
    }
}