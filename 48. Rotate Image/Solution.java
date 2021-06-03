public class Solution {
    public void rotate(int[][] matrix) {
        // rotate symmetrically
        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = i; j < matrix[i].length; j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //rotate horizontally
        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = 0; j < matrix[i].length / 2; j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }
    }
}
