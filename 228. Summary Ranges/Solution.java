class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            while (r < n - 1 && nums[r] + 1 == nums[r + 1]) r++;
            
            if (nums[l] != nums[r]) {
                sb.append(nums[l]);
                sb.append("->");
                sb.append(nums[r]);
                res.add(sb.toString());
            } else {
                sb.append(nums[l]);
                res.add(sb.toString());
            }
            
            r++;
            l = r;
            sb.setLength(0);
        }
        return res;
    }
}
