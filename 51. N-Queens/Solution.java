class Solution {
  List<List<String>> result = new ArrayList<>();
  List<String> candidate = new ArrayList<>();
  
  public List<List<String>> solveNQueens(int n) {
      int[] col = new int[n];
      int[] di1 = new int[n * 2 - 1];
      int[] di2 = new int[n * 2 - 1];
      
      char[][] matrix = new char[n][n];
      for (char[] c : matrix) {
          Arrays.fill(c, '.');
      }
      
      dfs(col, di1, di2, matrix, 0);
      
      return result;
  }
  
  private void dfs(int[] col, int[] di1, int[] di2, char[][] matrix, int start) {
      if (start == matrix.length) {  
          List<String> candidate = new ArrayList<>();
          for (char[] cc : matrix) {
              StringBuilder sb = new StringBuilder();
              for (char c : cc) {
                  sb.append(c);
              }
              candidate.add(sb.toString());
          }
          result.add(candidate);
          return;
      }
      
      for (int j = 0; j < matrix.length; j++) {
          if (col[j] != 1 && di1[start + j] != 1 && di2[(matrix.length - 1) + start - j] != 1) {
              col[j] = di1[start + j] = di2[(matrix.length - 1) + start - j] = 1;
              matrix[start][j] = 'Q';
              dfs(col, di1, di2, matrix, start + 1);
              col[j] = di1[start + j] = di2[(matrix.length - 1) + start - j] = 0;
              matrix[start][j] = '.';
          }
      }
  }
}
