class Solution {
  public List<List<Integer>> combine(int n, int k) {
      int[] nums = new int[n];
      
      for (int i = 0; i < n; i++) {
          nums[i] = i + 1;
      }
      
      int[] st = new int[n];
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> candidate = new ArrayList<>();
      
      dfs(result, candidate, nums, st, k, 0);
      
      return result;
  }
  
  private void dfs(List<List<Integer>> result, List<Integer> candidate, int[] nums, int[] st, int size, int start) {
      
      if (candidate.size() == size) {
          result.add(new ArrayList<>(candidate));
          return;
      }
      
      for (int i = start; i < nums.length; i++) {
          if (st[i] == 0) {
              st[i] = 1;
              candidate.add(nums[i]);
              dfs(result, candidate, nums, st, size, start);
              candidate.remove(candidate.size() - 1);
              st[i] = 0;
          }
          start ++;
      }
  }
}
