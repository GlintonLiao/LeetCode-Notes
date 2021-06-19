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
class BSTIterator {
        
    private Stack<TreeNode> nodeStack;
    
    public BSTIterator(TreeNode root) {
        nodeStack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null) {
            nodeStack.push(curr);
            
            if (curr.left != null) {
                curr = curr.left;
            } else {
                break;
            }
        }
    }
    
    public int next() {
        TreeNode node = nodeStack.pop();
        
        // traverse right branches
        TreeNode curr = node.right;
        
        while (curr != null) {
            nodeStack.push(curr);
            curr = curr.left;
        }
        
        return node.val;
    }
    
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
