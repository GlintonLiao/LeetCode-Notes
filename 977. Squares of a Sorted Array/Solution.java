class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int idx = 0;
        int j = 0;
        while (j < n && nums[j] < 0) j++;
        
        int i = j - 1;
        while (i >= 0 && j < n) {
            int ii = nums[i] * nums[i];
            int jj = nums[j] * nums[j];
            if (ii >= jj) {
                res[idx++] = jj;
                j++;
            } else {
                res[idx++] = ii;
                i--;
            }
        }
        
        while (i >= 0) {
            res[idx++] = nums[i] * nums[i--];
        }
        
        while (j < n) {
            res[idx++] = nums[j] * nums[j++];
        }
        
        return res;
    }
}