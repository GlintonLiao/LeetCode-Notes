/**
 *  LeetCode 上给这道题点踩的人很多
 *  确实，不知道这题在考什么
 */

class Solution {
  public String convert(String s, int numRows) {
      if (numRows == 1) return s;
      int N = 1010;
      char[][] matrix = new char[N][N];
      boolean tilted = false;
      int i = 0, j = 0;
      
      for (int k = 0; k < s.length(); k++) {
          matrix[i][j] = s.charAt(k);
          if (i == numRows - 1) tilted = true;
          if (i == 0) tilted = false;
          if (tilted) {
              i -= 1;
              j += 1;
          } else {
              i += 1;
          }
      }
      int endCol = j;
      
      // output 
      StringBuilder sb = new StringBuilder();
      for (i = 0; i < numRows; i++) {
          for (j = 0; j <= endCol; j++) {
              if (matrix[i][j] != 0) sb.append(matrix[i][j]);
          }
      }
      
      return sb.toString();
  }
}
