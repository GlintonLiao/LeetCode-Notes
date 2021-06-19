/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        
        // System.out.println("cur: " + root.val);
        if (root.left != null){            
            
            // try to set my left's next to my right
            if (root.right != null){
                root.left.next = root.right;
            } else {
                // right does not exist, try to set left to some eventual next's children
                setNextHelper(root, root.left);
            }
            
        }
        
        if (root.right != null){
            setNextHelper(root, root.right);
        }
        
        // Need to DFS with right first, because we need the "next train" to be populated as much as possible from the right side first
        connect(root.right);
        connect(root.left);
        
        return root;
        
    }
    
    private void setNextHelper(Node root, Node toSet){
        Node next = root.next;
        
        // loop until either next is null, or until one of next's children is non null. Then we can set it to one of those.
        while (next != null && next.left == null && next.right == null){
            next = next.next;
        }
        
        if (next != null){
            if (next.left != null){
                toSet.next = next.left;
            } else if (next.right != null){
                toSet.next = next.right;
            }
        }
    }
}
