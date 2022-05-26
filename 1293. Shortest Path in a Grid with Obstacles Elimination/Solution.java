class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] st = new boolean[m][n][k + 1];
        
        q.offer(new int[]{0, 0, 0, k});
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1], remain = p[3];
            
            if (x == m - 1 && y == n - 1) return p[2];
            
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
                if (grid[xx][yy] == 1 && remain > 0 && st[xx][yy][remain - 1] == false) {
                    st[xx][yy][remain - 1] = true;
                    q.offer(new int[]{xx, yy, p[2] + 1, remain - 1});
                }
                if (grid[xx][yy] == 0 && st[xx][yy][remain] == false) {
                    st[xx][yy][remain] = true;
                    q.offer(new int[]{xx, yy, p[2] + 1, remain});
                }
            }
        }
        return -1;        
    }
}