public class Solution {
  public int[][] reshapeMatrix(int[][] mat, int row, int col) {
    int m = mat.length;
    int n = mat[0].length;

    if (m * n != row * col) {
      return mat;
    }

    int[][] result = new int[row][col];
    int index = 0;

    for (int i = 0; i < m; i += 1) {
      for (int j = 0; j < n; j += 1) {
        result[i][j] = mat[index / n][index % n];
        index += 1;
      }
    }

    return result;
  }
}