class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int pre = 0, res = 0;
        for (int n : nums) {
            pre = (pre + n % k + k) % k;
            res += count[pre]++;
        }
        return res;
    }
}
