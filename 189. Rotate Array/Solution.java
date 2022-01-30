class Solution {
  public void rotate(int[] nums, int k) {
      if (k == 0 || k == nums.length) return;
      
      int[] newArr = new int[nums.length];
      if (k > nums.length) k = k % nums.length;
      int i = nums.length - k;
      int j = 0;
      
      while (i < nums.length) {
          newArr[j++] = nums[i++];
      }
      
      i = 0;
      
      while (i < nums.length - k) {
          newArr[j++] = nums[i++];
      }
      
      i = 0;
      
      while (i < nums.length) {
          nums[i] = newArr[i++];
      }
  }
}
