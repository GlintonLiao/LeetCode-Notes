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
    
  int[] levelSum = new int[10010];
  public int deepestLeavesSum(TreeNode root) {
      int deepest = traverse(root, 0);
      return levelSum[deepest];
  }
  
  private int traverse(TreeNode root, int level) {
      if (root == null) return level - 1;
      levelSum[level] += root.val;
      return Math.max(traverse(root.left, level + 1), traverse(root.right, level + 1));
  }
  
}
