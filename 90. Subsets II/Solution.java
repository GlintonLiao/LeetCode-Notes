class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> candidate = new ArrayList<>();
  
  public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      int[] st = new int[nums.length];
      for (int i = 0; i <= nums.length; i++) {
          dfs(nums, st, i, 0);
      }
      
      return res;
  }
  
  private void dfs(int[] nums, int[] st, int k, int start) {
      if (candidate.size() == k) {
          res.add(new ArrayList<>(candidate));
          return;
      }
      
      for (int i = start; i < nums.length; i++) {
          if (i > 0 && nums[i] == nums[i - 1] && st[i - 1] == 0) continue;
          
          if (st[i] == 0) {
              st[i] = 1;
              candidate.add(nums[i]);
              dfs(nums, st, k, i + 1);
              candidate.remove(candidate.size() - 1);
              st[i] = 0;
          }
      }
  }
}
