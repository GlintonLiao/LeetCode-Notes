class Solution {
  public int minEatingSpeed(int[] piles, int h) {
      int l = 1, r = 1000000000;
      while (l < r) {
          int mid = l + r >> 1;
          if (find(piles, mid) <= h) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      return l;
  }
  
  private int find(int[] piles, int speed) {
      int hour = 0;
      for (int i = 0; i < piles.length; i++) {
          hour += piles[i] / speed;
          if (piles[i] % speed != 0) {
              hour++;
          }
      }
      return hour;
  }
}
