class Solution {
    public int wiggleMaxLength(int[] nums) {
        int res = 1, prev = 0;
         
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i] - nums[i - 1];
            if ((curr > 0 && prev <= 0) || (curr < 0 && prev >= 0)) {
                res++;
                prev = curr;
            }
        }
        
        return res;
    }
}