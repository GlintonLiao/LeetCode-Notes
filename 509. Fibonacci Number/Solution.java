class Solution {
  public int fib(int n) {
    // edge case
    if (n == 0) return 0;

    // container table
    int[] dp = new int[n + 1];
    // base case
    dp[0] = 0;
    dp[1] = 1;
    // formula
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[i];
  }
}