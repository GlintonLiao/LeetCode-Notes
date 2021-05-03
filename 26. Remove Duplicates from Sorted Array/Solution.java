class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int ptr = 1;
        
        while (ptr < nums.length) {
            if (nums[index] == nums[ptr]) {
                ptr += 1;
            } else {
                index += 1;
                nums[index] = nums[ptr];
                ptr += 1;
            }
        }
        
        return index + 1;
    }
}
