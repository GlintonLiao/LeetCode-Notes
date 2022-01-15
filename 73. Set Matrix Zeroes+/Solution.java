class Solution {
  public void setZeroes(int[][] matrix) {
      int[] col = new int[200];
      int idx1 = 0;
      int[] row = new int[200];
      int idx2 = 0;
      for (int i = 0; i < matrix.length; i ++) {
          for (int j = 0; j < matrix[0].length; j ++) {
              if (matrix[i][j] == 0) {
                  col[idx1++] = j;
                  row[idx2++] = i;
              }
          }
      }
      while (--idx1 >= 0) {
          for (int k = 0; k < matrix.length; k++) {
              matrix[k][col[idx1]] = 0;
          }
      }
      while (--idx2 >= 0) {
          for (int k = 0; k < matrix[0].length; k++) {
              matrix[row[idx2]][k] = 0;
          }
      }
  }
}
