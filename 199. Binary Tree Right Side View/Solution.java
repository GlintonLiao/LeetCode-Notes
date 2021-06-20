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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(result, root, 0);
        return result;
    }
    
    private void traverse(List<Integer> result, TreeNode root, int level) {
        if (root == null) return;
        
        // the val can only be added once a level
        if (level == result.size()) {
            result.add(root.val);
        }
        
        // reversed pre-order traversal
        traverse(result, root.right, level + 1);
        traverse(result, root.left, level + 1);
    }
}
