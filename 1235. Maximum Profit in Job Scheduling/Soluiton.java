class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] intervals = new int[n][3];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }
        
        // sort by the end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int[] f = new int[n];
        f[0] = intervals[0][2];
        for (int i = 1; i < n; i ++) {
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                // find the maximun endTime which less than or equal to the startTime of the current job
                if (intervals[mid][1] <= intervals[i][0]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            
            f[i] = Math.max(f[i - 1], (intervals[l][1] <= intervals[i][0] ? f[l] : 0) + intervals[i][2]);
        }
        return f[n - 1];
    }
}
