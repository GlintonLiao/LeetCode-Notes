class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (max - min) / (n - 1));
        int size = (max - min) / d + 1;
        
        int[][] bucket = new int[size][2];
        for (int i = 0; i < size; i++) {
            Arrays.fill(bucket[i], -1);
        }
        
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - min) / d;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        
        int res = 0;
        int prev = -1;
        for (int i = 0; i < size; i++) {
            if (bucket[i][0] == -1) continue;
            if (prev != -1)
                res = Math.max(res, bucket[i][0] - bucket[prev][1]);
            prev = i;
        }
        return res;
    }
}