class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (getRight(k) - getLeft(k) + 1);
    }
    
    private long getLeft(int k) {
        long l = 0, r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + r >> 1;
            if (getZeros(mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    } 
    
    private long getRight(int k) {
        long l = 0, r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (getZeros(mid) <= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    private long getZeros(long num) {
        long count = 0;
        for (long n = num; n / 5 > 0; n = n / 5) {
            count += n / 5;
        }
        return count;
    }
}
