class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n + 1];
        int[] bt = new int[n + 1];
        
        for (int[] p : trust) {
            t[p[0]] = 1;
            bt[p[1]]++;
        }
        
        int idx = 1;
        int max = 0;
        for (int i = 0; i < n + 1; i++) {
            if (bt[i] > max) {
                max = bt[i];
                idx = i;
            }
        }
        
        if (t[idx] == 0 && bt[idx] == n - 1) {
            return idx;
        } else {
            return -1;
        }
    }
}
