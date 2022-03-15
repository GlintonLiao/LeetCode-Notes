class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder(s);
        int len = s.length();
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < len) {
            if (s.charAt(i) == '(') stack.push(i);
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    res.setCharAt(i, '*');
                }
            }
            i++;
        }
        
        while (!stack.isEmpty()) {
            res.setCharAt(stack.pop(), '*');
        }
        
        return res.toString().replaceAll("\\*", "");
    }
}
