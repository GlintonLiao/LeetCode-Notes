class Solution {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> candidate = new ArrayList<>();
  public List<List<Integer>> permuteUnique(int[] nums) {
      int[] st = new int[nums.length];
      
      Arrays.sort(nums);
      dfs(nums, st);
      
      return result;
  }
  
  private void dfs(int[] nums, int[] st) {
      
      if (candidate.size() == nums.length) {
          result.add(new ArrayList<>(candidate));
          return;
      }  
      
      for (int i = 0; i < nums.length; i ++) {
          if (i > 0 && nums[i - 1] == nums[i] && st[i - 1] == 0) continue;
          if (st[i] != 1) {
              st[i] = 1;
              candidate.add(nums[i]);
              dfs(nums, st);
              st[i] = 0;
              candidate.remove(candidate.size() - 1);
          }
      }
  }
}
