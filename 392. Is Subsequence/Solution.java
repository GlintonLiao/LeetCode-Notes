class Solution {
    public boolean isSubsequence(String s, String t) {
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        
        for (char c : t.toCharArray()) {    
            if (!q.isEmpty()) {
                if (q.peek() == c) {
                    q.poll();
                }
            }
        }
        
        return q.isEmpty();
    }
}
