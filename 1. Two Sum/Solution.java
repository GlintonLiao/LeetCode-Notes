public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2]; 
        for (int i1 = 0; i1 < nums.length; i1 += 1) {
            for (int i2 = 0; i2 < nums.length; i2 += 1) {
                if (i1 != i2 && nums[i1] + nums[i2] == target) {
                    output[0] = i1;
                    output[1] = i2;
                }
            }
        }
        return output;
    }
}
