class Solution {
  public int longestValidParentheses(String s) {
      
      String a = " ";
      s = a.concat(s);
      
      int len = s.length();
      if (len == 1) return 0;
      
      int[] f = new int[len];
      f[0] = 0;
      
      int result = 0;
      Stack<Integer> stack = new Stack<>();
      
      for (int i = 1; i < len; i++) {
          if (s.charAt(i) == '(') {
              stack.push(i);
              f[i] = 0;
          } else {
              if (!stack.isEmpty()) {
                  int l = stack.pop();
                  int curr = f[l - 1] + i - l + 1;
                  result = Math.max(result, curr);
                  f[i] = curr;
              } else {
                  f[i] = 0;
              }
          }
      }
   
      return result;
  }
}
