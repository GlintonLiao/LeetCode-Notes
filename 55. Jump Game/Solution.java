class Solution {
  public boolean canJump(int[] nums) {
      if (nums.length == 1) return true;
      int maxLength = 0;
      for (int i = 0; i < nums.length; i++) {
          if (maxLength < i) return false;
          maxLength = Math.max(maxLength, nums[i] + i);
      }
      return maxLength >= nums.length - 1;
  }
}
