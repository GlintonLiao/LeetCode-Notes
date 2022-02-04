class Solution {
  public String countAndSay(int n) {
      return helper(n, new StringBuilder("1"));
  }
  
  private String helper(int n, StringBuilder s) {
      if (n == 1) return s.toString();
      
      int l = 0,  r = 0;
      int len = s.length();
      StringBuilder sb = new StringBuilder();
      
      while (r < len) {
          while (r < len && s.charAt(r) == s.charAt(l)) r++;
          
          sb.append((char) (r - l + 48));
          sb.append(s.charAt(l));
          l = r;
      }
      
      return helper(n - 1, sb);
  }
}
