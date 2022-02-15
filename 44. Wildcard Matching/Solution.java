class Solution {
  public boolean isMatch(String s, String p) {
      int sLen = s.length(), pLen = p.length();
      boolean[][] f = new boolean[sLen + 1][pLen + 1];
      f[0][0] = true;
      
      for (int j = 1; j <= pLen; j++) {
          if (p.charAt(j - 1) == '*') {
              f[0][j] = true;
          } else {
              break;
          }
      }
      
      for (int i = 1; i <= sLen; i++) {
          for (int j = 1; j <= pLen; j++) {
              if (p.charAt(j - 1) != '*') {
                  if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                      f[i][j] = f[i - 1][j - 1];
                  }
              } else {
                  f[i][j] = f[i - 1][j] || f[i][j - 1];
              }
          }
      }
      
      return f[sLen][pLen];
  }
}
