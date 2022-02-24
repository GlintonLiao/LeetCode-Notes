class Solution {
  public int splitArray(int[] nums, int m) {
      int sum = nums[0], max = nums[0];
      
      for (int i = 1; i < nums.length; i ++) {
          sum += nums[i];
          max = Math.max(max, nums[i]);
      }
      
      int l = max, r = sum;
      while (l < r) {
          int mid = l + r >> 1;
          int n = split(nums, mid);
          if (n <= m) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      
      return l;
  }
  
  private int split(int[] nums, int max) {
      int count = 1;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
          if (sum + nums[i] > max) {
              count++;
              sum = nums[i];
          } else {
              sum += nums[i];
          }
      }
      return count;
  }
}
