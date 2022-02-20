class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
      int count = intervals.length;
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      int l = intervals[0][0];
      int r = intervals[0][1];
      
      for (int i = 1; i < intervals.length; i++) {
          if (intervals[i][0] == l) {
              count--;
              r = Math.max(intervals[i][1], r);
          } else if (intervals[i][0] > l && intervals[i][1] <= r) {
              count--;
          } else {
              l = intervals[i][0];
              r = intervals[i][1];
          }
      }
      
      return count;
  }
}
