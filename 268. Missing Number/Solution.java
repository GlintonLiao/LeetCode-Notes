class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0, sum2 = 0;
        for (int i = 1; i <= n; i++) {
            sum1 += i;
        }
        for (int x : nums) {
            sum2 += x;
        }
        return sum1 - sum2;
    }
}
