public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 1; i < 32; i++) {
            res += (n & 1);
            res <<= 1;
            n >>= 1;
        }
        return res;
    }
}
