class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        int[] st = new int[256];
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : arr) {
            count[c]++;
        }
        
        for (char c : arr) {
            count[c]--;
            if (st[c] == 1) continue;
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) break;
                st[stack.pop()] = 0;
            }
            stack.push(c);
            st[c] = 1;
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }
        
        return res.toString();
    }
}
