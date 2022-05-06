class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            int val = sum[i] % k;
            map.putIfAbsent(val, i);
        }
        
        int res = 0;
        for (int i = 1; i < sum.length; i++) {
            int t = sum[i] % k;
            if (map.containsKey(t) && i - map.get(t) >= 2) 
                return true;
        }
        return false;
    }
}