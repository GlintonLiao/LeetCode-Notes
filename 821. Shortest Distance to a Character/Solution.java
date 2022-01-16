class Solution {
  public int[] shortestToChar(String s, char c) {
      int[] result = new int[s.length()];
      Arrays.fill(result, Integer.MAX_VALUE);
      int idx = 0;
      for (int i = 0; i < s.length(); i ++) {
          if (s.charAt(i) == c) {
              while (idx < result.length) {
                  result[idx] = Math.min(result[idx], Math.abs(idx - i));
                  idx++;
              }
              idx = i;
          }
      }
      return result;
  }
}
