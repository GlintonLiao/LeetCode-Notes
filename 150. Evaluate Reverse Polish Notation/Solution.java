class Solution {
  public int evalRPN(String[] tokens) {
      Stack<Integer> nums = new Stack<>();
      
      for (String s : tokens) {
          if (!s.equals("+") && 
              !s.equals("-") &&
              !s.equals("*") &&
              !s.equals("/")) {
              nums.push(Integer.valueOf(s));
          } else {
              int b = nums.pop();
              int a = nums.pop();
              if (s.equals("+")) nums.push(a + b);
              if (s.equals("-")) nums.push(a - b);
              if (s.equals("*")) nums.push(a * b);
              if (s.equals("/")) nums.push(a / b);
          }
      }
      
      return nums.pop();
  }
}
