class Solution2 {
  public int[][] merge(int[][] intervals) {
      if (intervals.length == 1) return intervals;
          
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      List<int[]> result = new ArrayList<>();
      
      int l = intervals[0][0], r = intervals[0][1];
      
      for (int i = 1; i < intervals.length; i++) {
          if (intervals[i][0] <= r) {
              r = Math.max(intervals[i][1], r);
          } else {
              result.add(new int[]{l, r});
              l = intervals[i][0];
              r = intervals[i][1];
          }
      }
      
      result.add(new int[]{l, r});
      
      return result.toArray(new int[0][]);
  }
}
