/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    TreeNode res;
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(cloned, target.val);
        return res;
    }
    
    private void traverse(TreeNode root, int target) {
        if (root == null) return;
        
        if (root.val == target) {
            res = root;
            return;
        }
        traverse(root.left, target);
        traverse(root.right, target);
    }
}
