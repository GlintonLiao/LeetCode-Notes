class Solution {
    public int deleteAndEarn(int[] nums) {
        int N = 10010;
        int[] count = new int[N];
        for (int n : nums) {
            count[n] += n;
        }
        
        int[] f = new int[N];
        f[0] = count[0];
        f[1] = count[1];
        for (int i = 2; i < N; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + count[i]);
        }
        return f[N - 1];
    }
}
