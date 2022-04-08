class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int toShift = 0;
        
        while (left != right) {
            left >>= 1;
            right >>= 1;
            toShift ++;
        }
        
        return left << toShift;
    }
}
