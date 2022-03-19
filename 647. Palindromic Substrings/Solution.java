class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            res++;
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    res++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            
            l = i - 1; r = i;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    res++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
