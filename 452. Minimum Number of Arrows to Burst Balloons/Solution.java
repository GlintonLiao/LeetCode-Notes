class Solution {
  public int findMinArrowShots(int[][] points) {
      Arrays.sort(points, (a,b) -> compare(a, b));
      int start = points[0][0];
      int end = points[0][1];
      int cnt = points.length;
      for (int i = 1; i < points.length; i ++) {
          if (points[i][0] <= end) {
              start = points[i][0];
              end = Math.min(end, points[i][1]);
              cnt --;

          } else {
              start = points[i][0];
              end = points[i][1];
          }
      }
      return cnt;
  }
  
  // need to rewrite the compare function to avoid overflow
  private int compare(int[] l1, int[] l2) {
      if (l1[0] == l2[0]) {
          if (l1[1] > l2[1]) {
              return 1;
          } else {
              return -1;
          }

      } else {
          if (l1[0] < l2[0]) return -1;
          return 1;
             
      }
  }
}
