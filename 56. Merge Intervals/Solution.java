class Solution {
  public int[][] merge(int[][] intervals) {
      int ptr1 = -1;
      int ptr2 = -1;
      ArrayList<int[]> result = new ArrayList<>();
      for (int[] item : intervals) {
          if (ptr2 < item[0]) {
              if (ptr1 != -1) result.add(new int[]{ptr1, ptr2});
              ptr1 = item[0];
              ptr2 = item[1];
          } else {
              ptr2 = Math.max(ptr2, item[1]);
          }
      }
      if (ptr1 != -1) result.add(new int[]{ptr1, ptr2});
      return result;
  }
}
