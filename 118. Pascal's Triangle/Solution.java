import java.util.*;

class Solution {
    
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> generate(int numRows) {
      traverse(1, numRows);
      return res;
  }
  
  private void traverse(int curr, int target) {
      if (curr > target) return;
      
      int[] nums = new int[curr];
      nums[0] = 1;
      nums[curr - 1] = 1;
      if (res.size() >= 2) {
          List<Integer> prev = res.get(res.size() - 1);
          
          for (int i = 1; i < curr - 1; i++) {
              nums[i] = prev.get(i - 1) + prev.get(i);
          }
      }
      
      List<Integer> list = new ArrayList<>(nums.length);
      for (int n : nums) list.add(n);
      res.add(list);
      traverse(curr + 1, target);
  }
}
