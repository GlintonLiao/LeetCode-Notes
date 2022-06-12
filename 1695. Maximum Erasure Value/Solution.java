class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int res = 0, sum = 0;
        Set<Integer> set = new HashSet<>();
        while (r < n) {
            if (!set.contains(nums[r])) {
                set.add(nums[r]);
                sum += nums[r++];
                res = Math.max(res, sum);
            } else {
                set.remove(nums[l]);
                sum -= nums[l++];
            }
        }
        return res;
    }
}