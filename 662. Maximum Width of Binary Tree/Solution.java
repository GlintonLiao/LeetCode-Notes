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
    List<Integer> list = new ArrayList<>();
    int max = 1;
    
    public int widthOfBinaryTree(TreeNode root) {
        search(root, 0, 1);
        return max;
    }
    
    private void search(TreeNode root, int level, int idx) {
        if (root == null) return;
        if (level == list.size()) list.add(idx);
        max = Math.max(max, idx - list.get(level) + 1);
        search(root.left, level + 1, idx * 2);
        search(root.right, level + 1, idx * 2 + 1);
    }
}
