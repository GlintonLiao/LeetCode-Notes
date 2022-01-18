class Solution {
  public boolean detectCapitalUse(String word) {
      if (word.length() == 1) return true;
      int mode = 0;
      if ((int) word.charAt(0) < 97) mode = 1; // only the first capitalized
      if ((int) word.charAt(1) < 97) mode = 2; // all capitalized
      switch (mode) {
          case 0: 
              for (int i = 0; i < word.length(); i++) {
                  if ((int) word.charAt(i) < 97) return false;
              }
              break;
          case 1:
              for (int i = 1; i < word.length(); i++) {
                  if ((int) word.charAt(i) < 97) return false;
              }
              break;
          case 2:
              for (int i = 0; i < word.length(); i++) {
                  if ((int) word.charAt(i) >= 97) return false;
              }
              break;
      }
      return true;
  }
}
