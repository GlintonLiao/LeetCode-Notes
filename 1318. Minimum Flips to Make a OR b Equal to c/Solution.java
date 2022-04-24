class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        int xor = a ^ b;
        int and = a & b;
        for (int i = 0; i < 32; i++) {
            int t = c & 1;
            int x = xor & 1;
            int aa = and & 1;
            if (t == 1) {
                if (x == 0 && aa == 0) res ++;
            } else {
                if (x == 1) {
                    res++;
                } else if (x == 0 && aa == 1) {
                    res += 2;
                }
            }
            c >>= 1;
            xor >>= 1;
            and >>= 1;
        }
        return res;
    }
}