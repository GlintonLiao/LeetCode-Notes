class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int begin = -1, end = -2;
        while (l < n) {
            max = Math.max(max, nums[l]);
            if (nums[l] < max) {
                end = l;
            }
            l++;
        }
        while (r >= 0) {
            min = Math.min(min, nums[r]);
            if (nums[r] > min) {
                begin = r;
            }
            r--;
        }
        return end - begin + 1;
    }
}
