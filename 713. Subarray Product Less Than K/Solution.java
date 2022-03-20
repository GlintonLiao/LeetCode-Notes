class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int l = 0, r = 0;
        int pro = 1;
        
        while (r < n) {
            pro *= nums[r++]; 
            while (pro >= k && l < r) {
                pro /= nums[l++];
            }
            res += r - l;
        }
        return res;
    }
}
