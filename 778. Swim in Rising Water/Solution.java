class Solution {
    public int swimInWater(int[][] grid) {
        int time = grid[0][0];
        int n = grid.length, m = grid[0].length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] st = new boolean[n][m];
        
        pq.add(new Pair(0, 0, grid[0][0]));
        st[0][0] = true;
        
        while (true) {
            Pair p = pq.poll();
            time = Math.max(time, p.val);
            
            // key point
            if (p.x == n - 1 && p.y == n - 1) return time;
            
            for (int i = 0; i < 4; i++) {
                int xx = p.x + dx[i];
                int yy = p.y + dy[i];
                
                if (xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
                
                if (st[xx][yy] == false) {
                    pq.add(new Pair(xx, yy, grid[xx][yy]));
                    st[xx][yy] = true;
                }
            }
        }
    }
    
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int val;
        
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        public int compareTo(Pair o) {
            return Integer.compare(val, o.val);
        }
    }
}