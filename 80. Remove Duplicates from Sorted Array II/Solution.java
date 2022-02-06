class Solution {
  public int removeDuplicates(int[] nums) {
      int idx = 0;
      
      for (int n : nums) {
          // only assign the legel number
          if (idx < 2 || n > nums[idx - 2]) {
              nums[idx++] = n;
          }
      }
      
      return idx;
  }
}
