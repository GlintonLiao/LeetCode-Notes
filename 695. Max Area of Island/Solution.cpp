class Solution {
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> st(m, vector<bool>(n, false));
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                if (st[i][j]) continue;
                if (grid[i][j] == 0) continue;
                st[i][j] = true;
                queue<pair<int, int>> q;
                q.push({i, j});
                
                int curr = 0;
                while (q.size())
                {
                    auto p = q.front();
                    q.pop();
                    curr ++;
                    int x = p.first, y = p.second;
                    for (int i = 0; i < 4; i++)
                    {
                        int xx = x + dx[i], yy = y + dy[i];
                        if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
                        if (st[xx][yy]) continue;
                        if (grid[xx][yy] == 0) continue;
                        st[xx][yy] = true;
                        q.push({xx, yy});
                    }
                }
                res = max(res, curr);
            }
        return res;
    }
};