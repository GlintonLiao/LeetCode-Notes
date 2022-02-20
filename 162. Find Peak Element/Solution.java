class Solution {
  public int findPeakElement(int[] nums) {
      return find(nums, 0, nums.length - 1);
  }
  
  private int find(int[] nums, int l, int r) {
      if (l == r) return l;
      
      int mid = l + r >> 1;
      
      if (nums[mid] > nums[mid + 1]) {
          return find(nums, l, mid);
      } else {
          return find(nums, mid + 1, r);
      }
  }
}
