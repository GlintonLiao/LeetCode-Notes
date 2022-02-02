class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        
        int maxProfit = 0;
        int[] f = new int [prices.length];
        f[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            f[i] = Math.max(0, f[i - 1] + prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, f[i]);
        }
        
        return maxProfit;
    }
}
