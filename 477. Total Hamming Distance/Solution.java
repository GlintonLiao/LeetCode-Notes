class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = 0;
            for (int n : nums) {
                tmp += (n >> i) & 1;
            }
            res += tmp * (nums.length - tmp);
        }
        return res;
    }
}