class Solution {
  public int[][] generateMatrix(int n) {
      int[][] matrix = new int[n][n];
      int leftBound = 0, upperBound = 0, rightBound = n - 1, lowerBound = n - 1;
      int num = 1;
      
      while (num <= n * n) {
          // left to right
          if (upperBound <= lowerBound) {
              for (int j = leftBound; j <= rightBound; j++) {
                  matrix[upperBound][j] = num++;
              }
              upperBound++;
          }
          
          // top to bottom
          if (leftBound <= rightBound) {
              for (int i = upperBound; i <= lowerBound; i++) {
                  matrix[i][rightBound] = num++;
              }
              rightBound--;
          }
          
          // right to left
          if (upperBound <= lowerBound) {
              for (int j = rightBound; j >= leftBound; j--) {
                  matrix[lowerBound][j] = num++;
              }
              lowerBound--;
          }
          
          // bottom to top
          if (leftBound <= rightBound) {
              for (int i = lowerBound; i >= upperBound; i--) {
                  matrix[i][leftBound] = num++;
              }
              leftBound++;
          }
          
      }
      
      return matrix;
  }
}
