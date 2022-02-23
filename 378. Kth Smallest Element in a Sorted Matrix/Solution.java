class Solution {
  public int kthSmallest(int[][] matrix, int k) {
      int n = matrix.length;
      int l = matrix[0][0], r = matrix[n - 1][n - 1];
      
      while (l < r) {
          int mid = l + r >> 1;
          if (getLessEqual(matrix, mid) >= k) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      
      return l;
  }
  
  private int getLessEqual(int[][] matrix, int mid) {
      int n = matrix.length;
      int i = n - 1, j = 0;
      int res = 0;
      
      while (i >= 0 && j < n) {
          if (matrix[i][j] > mid) {
              i--;
          } else {
              res += i + 1;
              j++;
          }
      }
      
      return res;
  }
}
