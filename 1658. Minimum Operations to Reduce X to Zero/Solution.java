class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int a : nums) sum += a;
        
        int target = sum - x;
        if (target < 0) return -1;
        
        int l = 0, r = 0;
        int curr = 0;
        int res = -1;
        while (r < n) {
            curr += nums[r++];
            
            while (curr > target) {
                curr -= nums[l++];
            }
            
            if (curr == target) {
                res = Math.max(res, r - l);
            }
        }
        
        if (res == -1) 
            return -1;
        else 
            return n - res;
    }
}
