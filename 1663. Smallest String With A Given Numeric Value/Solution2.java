class Solution2 {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        k -= n;
        
        while (k > 0) {
            int tmp = Math.min(k, 25);
            arr[n - 1] += tmp;
            k -= tmp;
            n--;
        }
        
        return new String(arr);
    }
}
