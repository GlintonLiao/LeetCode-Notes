class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        
        int res = 0;
        for (int l = 1; l <= n; l += 2) {
            for (int i = 1; i < n - l + 2; i++) {
                System.out.println(i + " " + l);
                res += sum[i + l - 1] - sum[i - 1];
            }
        }
        return res;
    }
}
