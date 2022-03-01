class Solution {
  public int nthMagicalNumber(int n, int a, int b) {
      long gcd = gcd(a, b), lcm = (a * b) / gcd;
      long mod = (long)1e9 + 7;
      long l = 2, r = (long)1e14;
      
      while (l < r) {
          long mid = l + r >> 1;
          if (mid / a + mid / b - mid / lcm >= n) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      return (int)(l % mod);
  }
  
  private long gcd(long a, long b) {
      return b == 0 ? a : gcd(b, a % b);
  }
}
