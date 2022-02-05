class Solution {
  public boolean isMatch(String s, String p) {
      int sLen = s.length();
      int pLen = p.length();
      boolean[][] f = new boolean[sLen + 1][pLen + 1];
      
      // empty string can match empty string
      f[0][0] = true;
      
      // initialize pattern
      // the rule is: 
      // 1. Empty String can match empty string.
      // 2. * and its preceding char can treat as empty string.
      for (int j = 2; j <= pLen; j++) {
          if (p.charAt(j - 1) == '*') {
              f[0][j] = f[0][j - 2];
          }
      }
      
      for (int i = 1; i <= sLen; i++) {
          for (int j = 1; j <= pLen; j++) {
              if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                  f[i][j] = f[i - 1][j - 1];          // can match, then move i and j forward by 1
              } else if (p.charAt(j - 1) == '*') {
                  // two ways to choose, either true, then true.
                  // 1. * and its pre char can match, then i move forward by 1
                  // 2. can't match, then treat the * as empty string, move j forward by 2
                  f[i][j] = f[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && f[i - 1][j]; 
              }
          }
      }
      
      return f[sLen][pLen];
  }
}
