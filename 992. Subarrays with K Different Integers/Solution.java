class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return check(nums, k) - check(nums, k - 1);
    }
    
    private int check(int[] nums, int k) {
        int l = 0, r = 0;
        int n = nums.length;
        int[] count = new int[20001];
        int cnt = 0;
        int res = 0;
        while (r < n) {
            if (count[nums[r++]]++ == 0) cnt++;
            
            while (cnt > k) {
                if (count[nums[l++]]-- == 1) cnt--;
            }
            
            res += r - l;
        }
        return res;
    }
}
