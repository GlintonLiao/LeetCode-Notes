public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i += 1) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        // adding the result
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        
                        // skip duplicates
                        while (low < high && nums[low] == nums[low + 1]) {
                            low += 1;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high -= 1;
                        }
                        
                        // there may be different result starting with the same nums[i]
                        low += 1;
                        high -= 1;
                        
                    } else if (nums[low] + nums[high] < sum) {
                        low += 1;
                    } else {
                        high -= 1;
                    }
                }
            }
        }
        
        return result;
    }
}
