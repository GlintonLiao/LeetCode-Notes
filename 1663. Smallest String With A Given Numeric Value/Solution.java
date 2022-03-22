class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int val = Math.min(26, k - i);
            arr[i] = (char)('a' + val - 1);
            k -= val;
        }
        
        return new String(arr);
    }
}