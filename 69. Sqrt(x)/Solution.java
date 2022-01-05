class Solution {
  public int mySqrt(int x) {
    int l = 0, r = x;
    while (l < r) {
      int mid = l + r >> 1;
      if (mid >= x / mid) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}