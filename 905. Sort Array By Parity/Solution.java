class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int idx = 0;
        int i = 0;
        while (i < nums.length) {
            if ((nums[i] & 1) == 0) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx++;
            }
            i++;
        }
        return nums;
    }
}
