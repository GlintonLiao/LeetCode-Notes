class Solution {
  int count = 0;
  public int totalNQueens(int n) {
      int[] col = new int[n];
      int[] d1 = new int[n * 2 - 1];
      int[] d2 = new int[n * 2 - 1];
      
      dfs(0, col, d1, d2);
      return count;
  }
  
  private void dfs(int row, int[] col, int[] d1, int[] d2) {
      if (row == col.length) {
          count++;
          return;
      }
      
      for (int j = 0; j < col.length; j++) {
          if (col[j] == 0 && d1[row + j] == 0 && d2[col.length - 1 - row + j] == 0) {
              col[j] = 1;
              d1[row + j] = 1;
              d2[col.length - 1 - row + j] = 1;
              dfs(row + 1, col, d1, d2);
              col[j] = 0;
              d1[row + j] = 0;
              d2[col.length - 1 - row + j] = 0;
          }
      }
  }
}
