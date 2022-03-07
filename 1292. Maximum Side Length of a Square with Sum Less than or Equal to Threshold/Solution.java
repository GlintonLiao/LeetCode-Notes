class Solution {
    int m, n;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        
        int[][] s = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = mat[i - 1][j - 1] + s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }
        
        int l = 0, r = Math.min(m, n);
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (isSquareExist(s, threshold, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
    
    private boolean isSquareExist(int[][] s, int threshold, int len) {
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                if (s[i][j] - s[i-len][j] - s[i][j-len] + s[i-len][j-len] <= threshold) return true;
            }
        }
        return false;
    }
}
