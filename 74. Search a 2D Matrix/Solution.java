public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++ ) {
      int l = 0, r = matrix[i].length - 1;
      while (l < r) {
        int mid = l + r >> 1;
        if (matrix[i][mid] >= target) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      if (matrix[i][l] == target) return true;
    }
    return false;
  }
}
