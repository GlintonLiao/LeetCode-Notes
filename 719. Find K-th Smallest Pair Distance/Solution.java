class Solution {
  public int smallestDistancePair(int[] nums, int k) {
      Arrays.sort(nums);
      
      int l = 0, r = nums[nums.length - 1] - nums[0];
      
      while (l < r) {
          int mid = l + r >> 1;
          
          if (check(nums, mid) >= k) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      return l;
  }
  
  private int check(int[] nums, int max) {
      int count = 0;
      int i = 0;
      for (int j = 0; j < nums.length; j++) {
          while (nums[j] - nums[i] > max) {
              i++;
          }
          count += j - i;
      }
      return count;
  }
}