class Solution {
  public void solveSudoku(char[][] board) {
      dfs(board, 0, 0);
  }
  
  private boolean dfs(char[][] board, int i, int j) {
      int n = 9, m = 9;
      
      if (j == m) return dfs(board, i + 1, 0);
      
      if (i == n) return true;
      
      if (board[i][j] != '.') return dfs(board, i, j + 1);
      
      for (char c = '1'; c <= '9'; c++) {
          if (!isValid(board, i, j, c)) {
              continue;
          }
          
          board[i][j] = c;
          if (dfs(board, i, j + 1)) return true;
          board[i][j] = '.';
      }
      
      return false;
  }
  
  private boolean isValid(char[][] board, int i, int j, char c) {
      for (int x = 0; x < 9; x++) {
          if (board[i][x] == c) return false;
          if (board[x][j] == c) return false;
          if (board[(i / 3) * 3 + x / 3][(j / 3) * 3 + x % 3] == c) return false;
      }
      return true;
  }
}
