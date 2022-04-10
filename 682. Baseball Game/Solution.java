class Solution {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();
        
        for (String s : ops) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("+")){
                int x = stack.pop();
                int y = stack.peek();
                stack.push(x);
                stack.push(x + y);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
