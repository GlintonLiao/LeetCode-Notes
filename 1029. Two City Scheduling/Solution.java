public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int res = 0;
        int[] refund = new int[n * 2];
        int idx = 0;

        for (int[] cost : costs) {
            refund[idx++] = cost[1] - cost[0];
            res += cost[0];
        }

        Arrays.sort(refund);
        for (int i = 0; i < n; i++) {
            res += refund[i];
        }
        return res;
    }
  
}