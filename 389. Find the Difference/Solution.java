class Solution {
  public char findTheDifference(String s, String t) {
      int charCode = (int) t.charAt(t.length() - 1);
      for (int i = 0; i < s.length(); i++) {
          charCode -= (int) s.charAt(i);
          charCode += (int) t.charAt(i);
      }
      return (char) charCode;
  }
}
