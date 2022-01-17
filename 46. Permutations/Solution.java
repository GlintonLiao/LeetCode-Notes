class Solution {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> candidate = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
      
      dfs(nums);
      
      return result;
  }
  
  private void dfs(int[] nums) {
      
      if (candidate.size() == nums.length) {
          result.add(new ArrayList(candidate));
          return;
      }
      
      for (int j = 0; j < nums.length; j++) {
          if (!candidate.contains(nums[j])) {
              candidate.add(nums[j]);
              dfs(nums);
              candidate.remove(candidate.size() - 1);
          }
      }
  }
}
