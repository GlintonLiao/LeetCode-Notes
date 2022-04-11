class Solution {
    public int[] singleNumber(int[] nums) {
        // get the XOR value of two target numbers
        int tmp = 0;
        for (int n : nums) {
            tmp ^= n;
        }
        
        // lowbit, find the distinct position of two target numbers
        int mask = tmp & -tmp;
        
        // divide the nums into 2 groups according to the distinct position
        int n1 = 0, n2 = 0;
        for (int n : nums) {
            if ((n & mask) == 0) {
                n1 ^= n;
            } else {
                n2 ^= n;
            }
        }
        
        return new int[]{n1, n2};
    }
}