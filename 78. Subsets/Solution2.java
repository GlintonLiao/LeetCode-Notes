class Solution2 {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> candidate = new ArrayList<>();
      
      dfs(res, candidate, nums, 0);
      
      return res;
  }
  
  private void dfs(List<List<Integer>> res, List<Integer> candidate, int[] nums, int start) {
      res.add(new ArrayList<>(candidate));
      
      for (int i = start; i < nums.length; i++) {
          candidate.add(nums[i]);
          dfs(res, candidate, nums, i + 1);
          candidate.remove(candidate.size() - 1);
      }
  }
}
