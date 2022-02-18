/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
  public Node cloneGraph(Node node) {
      if (node == null) return null;
      Map<Integer, Node> map = new HashMap<>();
      
      return build(map, node);
  }
  
  private Node build(Map<Integer, Node> map, Node n) {
      
      if (map.containsKey(n.val)) {
          return map.get(n.val);
      }
          
      Node newNode = new Node(n.val);
      map.put(n.val, newNode);
      
      for (Node nei : n.neighbors) {
          newNode.neighbors.add(build(map, nei));
      }
      
      return newNode;
  }
}
