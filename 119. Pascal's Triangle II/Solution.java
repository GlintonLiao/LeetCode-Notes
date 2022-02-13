class Solution {
  public List<Integer> getRow(int rowIndex) {
      List<Integer> prev = new ArrayList<>();
      prev.add(1);
      
      return traverse(prev, rowIndex);
  }
  
  private List<Integer> traverse(List<Integer> prev, int rowIndex) {
      if (prev.size() - 1 == rowIndex) return prev;
      
      List<Integer> curr = new ArrayList<>();
      int n = prev.size() + 1;
      
      // init
      curr.add(1);
      for (int i = 1; i < n - 1; i++) {
          curr.add(0);
      }
      curr.add(1);
      
      // compute
      for (int i = 1; i < n - 1; i++) {
          curr.set(i, prev.get(i - 1) + prev.get(i));
      }
      
      return traverse(curr, rowIndex);
  }
}
