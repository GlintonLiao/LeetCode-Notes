class Solution {
  public int firstMissingPositive(int[] nums) {
      int idx = 0;
      while (idx < nums.length) {
          if (nums[idx] >= 1 && nums[idx] <= nums.length && nums[nums[idx] - 1] != nums[idx]) {
              swap(nums, idx, nums[idx] - 1);
          } else {
              idx++;
          }
          
      }
      
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] != i + 1) return i + 1;
      }
      
      return nums.length + 1;
  }
  
  private void swap(int[] nums, int ptr1, int ptr2) {
      int temp = nums[ptr1];
      nums[ptr1] = nums[ptr2];
      nums[ptr2] = temp;
  }
}
