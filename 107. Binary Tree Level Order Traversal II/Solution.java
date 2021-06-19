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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, root, 0);
        return result;
    }
    
    private void traverse(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;
        
        if (result.size() == level) {
            result.add(0, new ArrayList<Integer>());
        }
        
        result.get(result.size() - level - 1).add(root.val);
        
        traverse(result, root.left, level + 1);
        traverse(result, root.right, level + 1);    
    }
}
