public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    /* 
     * This is the general solution for the nSum problems
     */
    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        if (k == 2) {   // the basic two sum solution(two pointers binary search)
            int low = start;
            int high = length - 1;
            
            while (low < high) {
                int sum = nums[low] + nums[high];
                
                if (sum == target) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[low]);
                    path.add(nums[high]);
                    result.add(path);
                    
                    // skip duplicates
                    while (low < high && nums[low] == nums[low + 1]) {
                        low += 1;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high -= 1;
                    }
                    
                    low += 1;
                    high -= 1;
                    
                } else if (sum < target) {
                    low += 1;
                } else {
                    high -= 1;
                }
            }

        } else {   // need to reduce k
            
            // iterate through every possible start point
            for (int i = start; i < length - (k - 1); i += 1) {
                
                //skip duplicates
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                
                // call recursive function
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                
                // add current item to the result of the recursive call
                for (List<Integer> list : temp) {
                    list.add(0, nums[i]);
                }
                
                // adding to the final result
                result.addAll(temp);
            }
        }
        
        return result;
    }
}
