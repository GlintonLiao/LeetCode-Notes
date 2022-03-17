class Solution {
    public int scoreOfParentheses(String s) {
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int count = 0;
        
        while (i < len) {
            if (s.charAt(i) == '(') {
                stack.push(count);
                count = 0;
            } else {
                count = stack.pop() + Math.max(count * 2, 1);
            }
            i++;
        }
        
        return count;
    }
}
