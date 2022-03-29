class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;

        while (l < r) {
            int mid = l + r >> 1;
            int cnt = 0;

            for (int i = 0; i < nums.length; i++) 
                if (nums[i] <= mid) cnt ++;

            if (cnt > mid) {
                  r = mid;
            } else {
                  l = mid + 1;
            }
        }
        return l;
  }
}