class Solution {
  public int findKthNumber(int m, int n, int k) {
      int l = 1, r = m * n;
      
      while (l < r) {
          int mid = l + r >> 1;
          if (check(mid, m, n) >= k) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      
      return l;
  }
  
  private int check(int mid, int m, int n) {
      int count = 0;
      
      int i = m, j = 1;
      while (i >= 1 && j <= n) {
          if (i * j > mid) {
              i--;
          } else {
              count += i;
              j++;
          }
      }
      
      return count;
  }
}
