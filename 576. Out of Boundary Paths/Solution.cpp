class Solution {
public:
    int findPaths(int m, int n, int N, int x, int y) {
        if (!N) return 0;
        const int MOD = 1e9 + 7;
        int f[m][n][N + 1];
        memset(f, 0, sizeof(f));
        
        for (int i = 0; i < m; i++) {
            f[i][0][1]++;
            f[i][n - 1][1]++;
        }
        for (int j = 0; j < n; j++) {
            f[0][j][1]++;
            f[m - 1][j][1]++;
        }
        
        int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
        for (int k = 1; k <= N; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    for (int u = 0; u < 4; u++)
                    {
                        int xx = i + dx[u], yy = j + dy[u];
                        if (xx >= 0 && xx < m && yy >= 0 && yy < n) 
                        {
                            (f[i][j][k] += f[xx][yy][k - 1]) %= MOD;
                        }
                    }
        int res = 0;
        for (int k = 0; k <= N; k++)
            (res += f[x][y][k]) %= MOD;
        return res;
    }
};