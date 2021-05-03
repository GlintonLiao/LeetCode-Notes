class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr2 = 0;
        
        for (int ptr = 0; ptr < nums.length; ptr += 1) {
            if (nums[ptr] != val) {
                nums[ptr2] = nums[ptr];
                ptr2 += 1;
            }
        }
        
        return ptr2;
    }
}
