class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                res++;
                l++;
                r--;
            } else if (nums[l] + nums[r] < k) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
