class Solution {
    List<List<String>> res = new LinkedList<>();
    List<String> candidate = new LinkedList<>();
    int n;
    
    public List<List<String>> partition(String s) {
        n = s.length();
        dfs(s, 0);
        return res;
    }
    
    private void dfs(String s, int start) {
        if (start == n) {
            res.add(new LinkedList<>(candidate));
            return;
        }
        
        for (int j = start + 1; j <= n; j++) {
            String tmp = s.substring(start, j);
            if (isPalindrome(tmp)) {
                candidate.add(tmp);
                dfs(s, j);
                candidate.remove(candidate.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int m = s.length();
        int i = 0, j = m - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}