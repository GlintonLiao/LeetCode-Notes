class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        
        Deque<Character> stack2 = new LinkedList<>();
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stack2.push(c);
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) return false;
        }
        
        if (!stack1.isEmpty() || !stack2.isEmpty())
            return false;
        
        return true;
    }
}