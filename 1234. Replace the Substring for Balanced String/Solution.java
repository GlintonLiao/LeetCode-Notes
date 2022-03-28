class Solution {
    public int balancedString(String s) {
        int[] count = new int[128];
        int n = s.length();
        int k = n / 4;
        int l = 0,  r = 0;
        int res = n;
        
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        while (r < n) {
            count[s.charAt(r++)]--;
            
            while (l < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
                res = Math.min(res, r - l);
                count[s.charAt(l++)]++;
            }
        }
        
        return res;
        
    }
}