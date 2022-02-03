// 1. find the o at the edge
// 2. find the set connecting to the o
// 3. set the o to the x

class Solution {
  public void solve(char[][] board) {
      // search the left and top
      int rLen = board[0].length;
      int cLen = board.length;
      int i = 0, j = 0;
      
      while (j < rLen) {
          if (board[0][j] == 'O') dfs(board, 0, j);
          if (board[cLen - 1][j] == 'O') dfs(board, cLen - 1, j);
          j++;
      }
      
      
      while (i < cLen) {
          if (board[i][0] == 'O') dfs(board, i, 0);
          if (board[i][rLen - 1] == 'O') dfs(board, i, rLen - 1);
          i++;
      }
      
      for (i = 0; i < cLen; i++) {
          for (j = 0; j < rLen; j++) {
              if (board[i][j] == 'O') board[i][j] = 'X';
              if (board[i][j] == 'S') board[i][j] = 'O';
          }
      }
  }
  
  private void dfs(char[][] board, int i, int j) {
      if (i < 0 || i >= board.length || j < 0 && j >= board.length) return;
      board[i][j] = 'S';
      if (i + 1 < board.length && board[i + 1][j] == 'O') dfs(board, i + 1, j);
      if (i - 1 >= 0 && board[i - 1][j] == 'O') dfs(board, i - 1, j);
      if (j + 1 < board[0].length && board[i][j + 1] == 'O') dfs(board, i, j + 1);
      if (j - 1 >= 0 && board[i][j - 1] == 'O') dfs(board, i, j - 1);  
  }
}