class Solution {
  public boolean search(int[] nums, int target) {
      int l = 0, r = 0;
      while (l < nums.length - 1) {
          if (nums[l] > nums[l + 1]) break;
          l++;
      }
      
      if (nums[0] <= target || l == nums.length - 1) {
          r = l;
          l = 0;
      } else {
          l = l + 1;
          r = nums.length - 1;
      }
      
      while (l < r) {
          int mid = l + r >> 1;
          if (nums[mid] >= target) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      
      return nums[l] == target;
      
  }
}
