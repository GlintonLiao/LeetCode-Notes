class Solution {
    public String shortestPalindrome(String s) {
        String kmpStr = s + "#" + new StringBuilder(s).reverse().toString();
        return new StringBuilder(s.substring(kmp(kmpStr))).reverse().toString() + s;
    }
    
    private int kmp(String kmp) {
        int n = kmp.length();
        int[] next = new int[n];
        int fast = 1;
        int slow = 0;
        while (fast < n) {
            if (kmp.charAt(fast) == kmp.charAt(slow)) {
                next[fast] = slow + 1;
                fast++;
                slow++;
            } else if (slow != 0) {
                slow = next[slow - 1];
            } else {
                next[fast++] = 0;
            }
        }
        return next[kmp.length() - 1];
    }
}