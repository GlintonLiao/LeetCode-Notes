class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] arr = path.split("/");
        
        for (String s : arr) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (s.equals(".") || s.equals("") || s.equals("..")) {
                continue;
            } else {
                stack.push(s);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append('/');
            res.append(stack.pollLast());
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}