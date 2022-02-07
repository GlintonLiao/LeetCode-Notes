class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      int[] st = new int[nums.length];
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> candidate = new ArrayList<>();
      
      for (int i = 0; i <= nums.length; i++) {
          dfs(res, candidate, st, nums, 0, i);
      }
      
      return res;
  }
  
  private void dfs(List<List<Integer>> res, List<Integer> candidate, int[] st, int[] nums, int start, int k) {
      if (candidate.size() == k) {
          res.add(new ArrayList<>(candidate));
          return;
      }
      
      for (int i = start; i < nums.length; i++) {
          if (st[i] == 0) {
              st[i] = 1;
              candidate.add(nums[i]);
              dfs(res, candidate, st, nums, start, k);
              candidate.remove(candidate.size() - 1);
              st[i] = 0;
          }
          start += 1;
      }
  }
}