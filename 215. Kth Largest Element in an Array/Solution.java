public class Solution {
  public int findKthLargest(int[] nums, int k) {
    quickSort(nums, 0, nums.length - 1);
    return nums[nums.length - k];
  }

  private void quickSort(int[] nums, int l, int r) {
    if (l >= r) return;
    int i = l - 1, j = r + 1, x = nums[l + r >> 1];
    while (i < j) {
      do i++; while (i < x);
      do j--; while (j > x);
      if (i < j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    quickSort(nums, l, j);
    quickSort(nums, j + 1, r);
  }
}
