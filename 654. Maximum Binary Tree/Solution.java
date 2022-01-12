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
  public TreeNode constructMaximumBinaryTree(int[] nums) {
      TreeNode root = traverse(0, nums.length - 1, nums);
      return root;
  }
  private TreeNode traverse(int l, int r, int[] nums) {
      if (l > r) return null;
      int maxIndex = l;
      int max = 0;
      for (int i = l; i <= r; i++) {
          if (max < nums[i]) {
              max = nums[i];
              maxIndex = i;
          }
      }
      TreeNode root = new TreeNode(max);
      root.left = traverse(l, maxIndex - 1, nums);
      root.right = traverse(maxIndex + 1, r, nums);
      return root;
  }
}
