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
      
        for (int i = 1, j = n; i <= m; i++) {
            while (i * j > mid) j--;
            count += j;
        }
      
      return count;
    }
}
