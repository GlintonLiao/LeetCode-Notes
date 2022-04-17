class Solution {
    public int findComplement(int num) {
        int k = 0;
        while (k < num) 
            k = (k << 1) | 1;
        return k - num;
    }
}