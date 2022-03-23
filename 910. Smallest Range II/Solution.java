class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = nums[0] + k, r = nums[n - 1] - k;
        int res = nums[n - 1] - nums[0];
        
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(r, nums[i] + k);
            int min = Math.min(l, nums[i + 1] - k);
            res = Math.min(res, max - min);
        }
        
        return res;
    }
}
