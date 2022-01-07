public class Solution {
  public String longestPalindrome(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      String l1 = helper(s, i, i);
      String l2 = helper(s, i, i + 1);
      result = result.length() > l1.length() ? result : l1;
      result = result.length() > l2.length() ? result : l2;
    }
    return result;
  }

  private String helper(String s, int l, int r) {
    while (l >= 0 && r <= s.length() - 1) {
      if (s.charAt(l) == s.charAt(r)) {
        l--;
        r++;
      } else {
        return s.substring(l + 1, r);
      }
    }
    return s.substring(l + 1, r);
  }
}
