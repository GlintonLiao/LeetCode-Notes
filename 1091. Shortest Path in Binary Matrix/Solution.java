class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if (grid[0][0] == 1) return -1;
        
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});  // first element -> index; second element -> step;
        
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        
        while (!q.isEmpty()) {
            
            int[] curr = q.poll();
            if (curr[0] == (n * n) - 1) return curr[1];  // reach the bottom-right cell
            
            for (int i = 0; i < 8; i++) {
                
                // get the next point
                int xx = curr[0] / n + dx[i];
                int yy = curr[0] % n + dy[i];
                
                // cut the impossible branch
                if (xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
                if (grid[xx][yy] == 1) continue;
                
                // visited the point, push it into the queue
                grid[xx][yy] = 1;
                q.offer(new int[]{xx * n + yy, curr[1] + 1});
            }
        }
        
        // when there is no element in the queue, means we don't have a path to the bottom-right cell
        return -1;
    }
}