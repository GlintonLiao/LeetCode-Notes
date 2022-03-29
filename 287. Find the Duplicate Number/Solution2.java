class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] st = new boolean[nums.length];
        
        for (int n : nums) {
            if (st[n]) return n;
            st[n] = true;
        }
        
        return -1;
    }
}
