class Solution {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> cand = new ArrayList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      dfs(candidates, target, 0);
      return res;
  }
  
  private void dfs(int[] candidates, int target, int start) {
      if (target < 0) return;
      
      if (target == 0) {
          res.add(new ArrayList<>(cand));
          return;
      }
      
      for (int i = start; i < candidates.length; i++) {
          cand.add(candidates[i]);
          dfs(candidates, target - candidates[i], i);
          cand.remove(cand.size() - 1);
      }
  }
}
