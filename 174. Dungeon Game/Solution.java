class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
      int n = dungeon.length, m = dungeon[0].length;
      int[][] f = new int[n][m];
      
      f[n - 1][m - 1] = Math.max(1 - dungeon[n - 1][m - 1], 1);
      
      // init
      for (int i = n - 2; i >= 0; i--) {
          f[i][m - 1] = Math.max(f[i + 1][m - 1] - dungeon[i][m - 1], 1);
      }
      for (int j = m - 2; j >= 0; j--) {
          f[n - 1][j] = Math.max(f[n - 1][j + 1] - dungeon[n - 1][j], 1);
      }
      
      // main loop
      for (int i = n - 2; i >= 0; i--) {
          for (int j = m - 2; j >= 0; j--) {
              int down = Math.max(f[i + 1][j] - dungeon[i][j], 1);
              int right = Math.max(f[i][j + 1] - dungeon[i][j], 1);
              f[i][j] = Math.min(down, right);
          }
      }
      
      return f[0][0];
  }
}
