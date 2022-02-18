class Solution {
  public String removeKdigits(String num, int k) {
      int n = num.length();
      if (n == k) return "0";
      
      LinkedList<Character> stack = new LinkedList<>();
      int i = 0;
      
      while (i < n) {
          while (k > 0 && !stack.isEmpty() && stack.getLast() > num.charAt(i)) {
              stack.pollLast();
              k--;
          }
          stack.add(num.charAt(i));
          i++;
      }
      
      while (k > 0) {
          stack.pollLast();
          k--;
      }
      
      while (stack.size() != 1 && stack.getFirst() == '0') {
          stack.poll();
      }
      
      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
          sb.append(stack.poll());
      }
      
      return sb.toString();
  }
}