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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> selection = new ArrayList<>();
        traverse(result, selection, root, targetSum);
        return result;
    }
    
    private void traverse(List<List<Integer>> result, List<Integer> selection, TreeNode root, int targetSum) {
        if (root == null) return;
            
        selection.add(root.val);
        
        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList(selection));
        } else {
            traverse(result, selection, root.left, targetSum - root.val);
            traverse(result, selection, root.right, targetSum - root.val);               
        }
        
        selection.remove(selection.size() - 1);
    }
}
