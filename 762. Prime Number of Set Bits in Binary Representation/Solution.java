class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += count(i);
        }
        return res;
    }
    
    private int count(int i) {
        int cnt = 0;
        while (i != 0) {
            cnt += (i & 1);
            i >>= 1;
        }
        
        if (cnt <= 1) return 0;
        for (int j = 2; j <= cnt / j; j++) {
            if (cnt % j == 0) return 0;
        }
        return 1;
    }
}
