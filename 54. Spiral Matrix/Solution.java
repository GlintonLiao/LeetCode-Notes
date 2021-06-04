public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = 0;
        int right = m - 1;
        int up = 0;
        int down = n - 1;
        
        if (matrix == null || matrix.length == 0) { return result; }
        
        while (result.size() < m * n) {
            
            // left to right
            for (int j = left; j <= right && result.size() < n * m; j += 1) {
                result.add(matrix[up][j]);
            }
            
            // up to down
            for (int i = up + 1; i <= down - 1 && result.size() < n * m; i += 1) {
                result.add(matrix[i][right]);
            }
            
            //right to left
            for (int j = right; j >= left && result.size() < n * m; j -= 1) {
                result.add(matrix[down][j]);
            }
            
            // down to up
            for (int i = down - 1; i >= up + 1 && result.size() < n * m; i -= 1) {
                result.add(matrix[i][left]);
            }
            
            left += 1;
            right -= 1;
            up += 1;
            down -= 1;
        }
        
        return result;
    }
}
