class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {

      List<int[]> result = new ArrayList<>();
      int l = 0;
      int r = 0;
      int i = 0;
      
      if (intervals.length == 0) {
          result.add(newInterval);
          return result.toArray(new int[0][0]);
      } 
      
      while (i < intervals.length && newInterval[0] > intervals[i][1]){
          l = intervals[i][0];
          r = intervals[i][1];
          result.add(new int[]{l, r});
          i++;
      }
      
      if (i >= intervals.length) {
          result.add(new int[]{newInterval[0], newInterval[1]});
          return result.toArray(new int[0][0]);
      }
      
      l = Math.min(intervals[i][0], newInterval[0]);
      r = newInterval[1];
      
      while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
          r = Math.max(r, intervals[i][1]);
          i++;
      }
      
      result.add(new int[]{l, r});
      
      while (i < intervals.length) {
          l = intervals[i][0];
          r = intervals[i][1];
          result.add(new int[]{l, r});
          i++;
      }
      
      return result.toArray(new int[0][0]);
  }
}
