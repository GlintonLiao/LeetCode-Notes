class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] f = new double[110][110];
        f[0][0] = poured;
        
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] > 1) {
                    double exd = f[i][j] - 1;
                    f[i + 1][j] += exd / 2;
                    f[i + 1][j + 1] += exd / 2;
                }
            }
        }
        
        return f[query_row][query_glass] > 1 ? 1 : f[query_row][query_glass];
    }
}
