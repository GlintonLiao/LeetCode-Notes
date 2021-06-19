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
    public TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        return build(nums, low, high);
    }
    
    private TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);

        return root;
    }
}
