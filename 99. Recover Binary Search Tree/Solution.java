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
    
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE); // to avoid null pointer exception
    
    public void recoverTree(TreeNode root) {
        
        // In order traversal to find two element
        traverse(root);
        
        // swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
        
    }
    
    private void traverse(TreeNode root) {
        if (root == null) { return; }
        
        traverse(root.left);
        
        // if the first element has not been found, assign it to prevElement
        if (firstElement == null && prevElement.val > root.val) {
            firstElement = prevElement;
        }
        
        // if the first element is found, assign the second element to the root
        if (firstElement != null && prevElement.val > root.val) {
            secondElement = root;
        }
        
        prevElement = root;
        
        traverse(root.right);
    }
}
