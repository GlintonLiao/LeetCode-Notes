class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        int res = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        map.put(0, 0);
        
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
            map.put(sum[i], i);
        }
        
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(sum[i] - target)) {
                minLen = Math.min(minLen, i - map.get(sum[i] - target));
            }
            
            if (map.containsKey(sum[i] + target) && minLen < Integer.MAX_VALUE) {
                res = Math.min(res, map.get(sum[i] + target) - i + minLen);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}