class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] sumList = new int[nums.length];
        
        for (int i = 0; i < nums.length; i += 1) {
            sum += nums[i];
            sumList[i] = sum;
        }
        
        return sumList;
    }
}