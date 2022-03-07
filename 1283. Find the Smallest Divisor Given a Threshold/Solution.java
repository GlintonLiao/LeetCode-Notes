class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = (int)1e6;
        while (l < r) {
            int mid = l + r >> 1;
            int sum = check(nums, mid);
            if (check(nums, mid) <= threshold) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private int check(int[] nums, int d) {
        int sum = 0;
        for (int n : nums) {
            sum += n / d;
            if (n % d != 0) sum ++;
        }
        return sum;
    }
}
