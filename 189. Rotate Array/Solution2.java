class Solution2 {
  public void rotate(int[] nums, int k) {
      if (k == 0 || k == nums.length) return;
      
      if (k > nums.length) k = k % nums.length;
      reverse(nums, 0, nums.length - k - 1);
      reverse(nums, nums.length - k, nums.length - 1);
      reverse(nums, 0, nums.length - 1);
  }
  
  private void reverse(int[] nums, int l, int r) {
      while (l < r) {
          int temp = nums[l];
          nums[l++] = nums[r];
          nums[r--] = temp;
      }
  }
}
