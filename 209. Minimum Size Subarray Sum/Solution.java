class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = 0;
        int l = 0, r = 0;
        
        while (r < nums.length) {
            target -= nums[r++];
            
            while (target <= 0) {
                target += nums[l];
                if (r - l < res || res == 0) res = r - l;
                l++;
            }
        }
        
        return res;
    }
}
