class Solution {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> candidate = new LinkedList<>();
    int n, k;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        this.k = k;
        dfs(1, 0);
        return res;
    }
    
    private void dfs(int start, int sum) {
        if (candidate.size() == k && sum == n) {
            res.add(new LinkedList<>(candidate));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (sum + i <= n) {
                candidate.add(i);
                dfs(i + 1, sum + i);
                candidate.remove(candidate.size() - 1);
            }
        }
    }
}
