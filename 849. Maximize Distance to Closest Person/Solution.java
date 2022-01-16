class Solution {
  public int maxDistToClosest(int[] seats) {
      int l = -1, r = -1;
      int max = 0;
      for (int i = 0; i < seats.length; i++) {
          if (seats[i] == 1) {
              if (l == -1) {
                  l = max = i;
              } else {
                  r = i;
                  max = Math.max(max, r - l >> 1);
                  l = r;
              }
          }
          
          // check the count of the 0 after last 1
          if (i == seats.length - 1) {
              max = Math.max(max, i - Math.max(l, r));
          }
      }
      return max;
  }
}
