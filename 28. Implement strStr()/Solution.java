class Solution {
  public int strStr(String haystack, String needle) {
      if (needle.length() == 0) return 0;
      
      String supplement = " ";
      haystack = supplement.concat(haystack);
      needle = supplement.concat(needle);
      
      char[] s = haystack.toCharArray();
      char[] p = needle.toCharArray();
      int n = s.length - 1, m = p.length - 1;
      int[] ne = new int[50050];
      
      for (int i = 2, j = 0; i <= m; i++) {
          while (j != 0 && p[i] != p[j + 1]) j = ne[j];
          if (p[i] == p[j + 1]) j++;
          ne[i] = j;
      }
      
      for (int i = 1, j = 0; i <= n; i++) {
          while (j != 0 && s[i] != p[j + 1]) j = ne[j];
          if (s[i] == p[j + 1]) j++;
          if (j == m) {
              j = ne[j];
              return i - m;
          }
      }
      
      return -1;
  }
}
