class Solution {
  public int myAtoi(String s) {
      if (s.length() == 0) return 0;
      int i = 0;
      StringBuilder sb = new StringBuilder();
      while (s.charAt(i) == ' ') {
          i ++;
          if (i >= s.length()) return 0;
      }
      if (s.charAt(i) == '+' || s.charAt(i) == '-' || ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57)) {
          sb.append(s.charAt(i++));
      }
      while (i < s.length() && (int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57 ) sb.append(s.charAt(i++));
      
      String rs = sb.toString();
      if (rs.length() == 0 || (rs.equals("+") || rs.equals("-"))) return 0;
      
      try {
          return Integer.parseInt(rs);
      } catch (Exception e) {
          if (rs.charAt(0) == '-') return Integer.MIN_VALUE;
          return Integer.MAX_VALUE;
      }
  }
}
