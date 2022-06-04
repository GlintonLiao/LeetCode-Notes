class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int next[] = new int[n];
        int i = 1;
        int now = 0; //通过now来转化下一个长度
        while (i < n) {
            if (s.charAt(i) == s.charAt(now)) {
                now++;
                next[i++] = now;
            } else if (now == 0){
                i++;
            } else {
                now = next[now - 1];
            }
        }
        return next[n - 1] == 0 ? "" : s.substring(0, next[n - 1]);
    }
}