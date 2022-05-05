class Solution {
    
    int[][] r;

    public Solution(int[][] rects) {
        r = rects;
    }
    
    public int[] pick() {
        int idx = -1, cnt = 0;
        Random rand = new Random();
        for (int i = 0; i < r.length; i++) {
            int curr = (r[i][2] - r[i][0] + 1) * (r[i][3] - r[i][1] + 1);
            cnt += curr;
            if (rand.nextInt(cnt) < curr) idx = i;
        }
        int[] res = r[idx];
        int x1 = res[0], x2 = res[2], y1 = res[1], y2 = res[3];
        return new int[]{x1 + rand.nextInt(x2 - x1 + 1), y1 + rand.nextInt(y2 - y1 + 1)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
