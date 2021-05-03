class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int item : nums) {
            if (item != 0) {
                nums[index++] = item;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}