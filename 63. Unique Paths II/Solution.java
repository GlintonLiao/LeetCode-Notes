class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int n = obstacleGrid.length;
      int m = obstacleGrid[0].length;
      int[][] f = new int[n + 1][m + 1];
      f[0][1] = 1;
      
      for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= m; j++) {
              if (obstacleGrid[i - 1][j - 1] == 1) {
                  f[i][j] = 0;
              } else {
                  f[i][j] = f[i - 1][j] + f[i][j - 1];
              }
          }
      }
      
      return f[n][m];
  }
}
