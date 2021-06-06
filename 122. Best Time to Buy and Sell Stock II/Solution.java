public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i += 1;
            }
            
            // need increment to avoid infinite loop for "[1]"
            int min = prices[i++];
            
            // find next local maximum
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i += 1;
            }
            
            if (i < prices.length) {
                profit += prices[i++] - min;
            }
        }
        
        return profit;
    }
}
