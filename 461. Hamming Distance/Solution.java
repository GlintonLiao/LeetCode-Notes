class Solution {
    public int hammingDistance(int x, int y) {
        int k = x ^ y;
        int res = 0;
        while (k != 0) {
            res += k & 1;
            k >>= 1;
        }
        return res;
    }
}
