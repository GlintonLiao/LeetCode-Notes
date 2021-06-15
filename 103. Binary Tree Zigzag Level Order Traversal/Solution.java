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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, root, 0);
        return result;
    }
    
    private void traverse(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;
        
        if (level == result.size()) {
            result.add(new ArrayList<Integer>());
        }
        
        List<Integer> levelList = result.get(level);
        
        if (level % 2 == 0) {
            levelList.add(root.val);
        } else {
            levelList.add(0, root.val);
        }
        
        traverse(result, root.left, level + 1);
        traverse(result, root.right, level + 1);
    }
}
