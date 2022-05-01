class NumMatrix {
    
    int[][] S;
    int n, m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        S = new int[n + 1][m + 1];
        
        S[0][0] = matrix[0][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return S[row2 + 1][col2 + 1] - S[row1][col2 + 1] - S[row2 + 1][col1] + S[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
