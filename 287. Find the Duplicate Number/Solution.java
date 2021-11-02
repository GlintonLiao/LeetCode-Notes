class Solution {
  public int findDuplicates(int[] nums) {
    int low = 1;
    int high = nums.length = 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      int count = 0;

      for (int i = 0; i < nums.length; i += 1) {
        if (nums[i] <= mid) {
          count += 1;
        }
      }

      if (count > mid) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
}