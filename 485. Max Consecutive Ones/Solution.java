class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = 0;
        for (int item : nums) {
            if (item == 0) {
                cur = 0;
            } else {
                cur += 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
