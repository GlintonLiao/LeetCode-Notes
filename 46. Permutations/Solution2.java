class Solution {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> candidate = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
      int[] st = new int[nums.length];  
      
      for (int i = 0; i < nums.length; i++) {
          dfs(i, nums, st);
      }
      
      return result;
  }
  
  private void dfs(int i, int[] nums, int[] st) {
      candidate.add(nums[i]);
      st[i] = 1;
      
      if (candidate.size() == nums.length) {
          result.add(new ArrayList(candidate));
      }
      
      for (int j = 0; j < nums.length; j++) {
          if (st[j] != 1) {
              dfs(j, nums, st);
          }
      }
      
      candidate.remove(candidate.size() - 1); 
      st[i] = 0;
  }
}
