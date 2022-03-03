class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int w : weights) {
            max =  Math.max(max, w);
            sum += w;
        }
        
        int l = max, r = sum;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private int check(int[] weights, int capacity) {
        int days = 1, v = 0;
        for (int w : weights) {
            if (v + w <= capacity) {
                v += w;
            } else {
                days += 1;
                v = w;
            }
        }
        return days;
    }
}
