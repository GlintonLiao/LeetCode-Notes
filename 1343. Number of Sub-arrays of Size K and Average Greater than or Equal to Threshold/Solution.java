class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        
        int res = 0;
        for (int i = k; i <= n; i++) {
            if (sum[i] - sum[i - k] >= threshold * k) {
                res++;
            }
        }
        
        return res;
    }
}
