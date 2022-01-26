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
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> result =  new ArrayList<>();
      traverse(result, root1);
      traverse(result, root2);
      result.sort((a, b) -> a - b);
      return result;
  }
  
  private void traverse(List<Integer> result, TreeNode root) {
      if (root == null) return;
      traverse(result, root.left);
      result.add(root.val);
      traverse(result, root.right);
  }
}
