class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1, r = (int)1e9 + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (canMake(bloomDay, m, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        if (l == (int)1e9 + 1) {
            return -1;
        } else {
            return l;
        }
    }
    
    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int i = 0, j = 0;
        while (j < bloomDay.length) {
            while (j < bloomDay.length && bloomDay[j] <= day) {
                j++;
            }
            
            if (j - i >= k) {
                int count = (j - i) / k;
                m -= count;
            }
            
            j++;
            i = j;
        }
        return m <= 0;
    }
}
