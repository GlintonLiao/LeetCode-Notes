class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[][] f = new int[n + 1][n + 1];
      
      for (int[] num : f) {
          Arrays.fill(num, Integer.MAX_VALUE);
      }
      
      f[1][1] = triangle.get(0).get(0);
      for (int i = 2; i <= n; i++) {
          for (int j = 1; j <= i; j++) {
              f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i - 1).get(j - 1);
          }
      }
      
      int res = Integer.MAX_VALUE;
      for (int j = 1; j <= n; j++) {
          res = Math.min(res, f[n][j]);
      }
      
      return res;
  }
}
