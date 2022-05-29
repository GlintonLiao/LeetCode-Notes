class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] A = new int[n];
        int[] B = new int[n];
        
        for (int i = 1; i < n; i++) {
            B[i] = B[i - 1] + (s.charAt(i - 1) == 'b' ? 1 : 0);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            A[i] = A[i + 1] + (s.charAt(i + 1) == 'a' ? 1 : 0);
        }
        
        int res = n;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, A[i] + B[i]);
        }
        return res;
    }
}