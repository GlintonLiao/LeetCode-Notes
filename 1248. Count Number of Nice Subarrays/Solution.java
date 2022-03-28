class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return check(nums, k) - check(nums, k - 1);
    }
    
    private int check(int[] nums, int k) {
        int cnt = 0;
        int l = 0, r = 0;
        int n = nums.length;
        int res = 0;
        
        while (r < n) {
            if ((nums[r++] & 1) == 1) cnt++;
            
            while (cnt > k) {
                if ((nums[l++] & 1) == 1) cnt--;
            }
            
            res += r - l;
        }
        
        return res; 
    }
}
