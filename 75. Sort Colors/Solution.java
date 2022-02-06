class Solution {
  public void sortColors(int[] nums) {
      quickSort(nums, 0, nums.length - 1);
  }
  
  private void quickSort(int[] nums, int l, int r) {
      if (l >= r) return;
      
      int i = l - 1, j = r + 1, x = nums[l + r >> 1];
      
      while (i < j) {
          do i++; while (nums[i] < x);
          do j--; while (nums[j] > x);
          
          if(i < j) {
              int temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
          }
      }
      
      quickSort(nums, l, j);
      quickSort(nums, j + 1, r);
  }
}
