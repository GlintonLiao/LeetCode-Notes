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
    
  private StringBuilder sb = new StringBuilder();
  int sum = 0;
  public int sumRootToLeaf(TreeNode root) {
      dfs(root);
      return sum;
  }
  
  private void dfs(TreeNode root) {
      if (root == null) return;
      if (root.left == null && root.right == null) {
          sb.append(root.val);
          sum += Integer.parseInt(sb.toString(), 2);
          sb.deleteCharAt(sb.length() - 1);
          return;
      }
      sb.append(root.val);
      dfs(root.left);
      dfs(root.right);
      sb.deleteCharAt(sb.length() - 1);
  }
}
