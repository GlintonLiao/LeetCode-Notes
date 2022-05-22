class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        int n = cardPoints.length;
        int[] sum = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + cardPoints[i - 1];
        }
        
        if (k == n) return sum[n];
        
        int min = Integer.MAX_VALUE;
        int l = 1, r = n - k;
        while (r <= n) {
            // System.out.println(l + " " + r);
            min = Math.min(min, sum[r++] - sum[l++ - 1]);
        }
        
        return sum[n] - min;
    }
}
