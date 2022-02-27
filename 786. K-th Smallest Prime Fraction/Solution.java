class Solution {
    static int x;
    static int y;
    
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l = 0;
        double r = 1;
        
        while (true) {
            double mid = (l + r) / 2;
            int count = check(arr, mid);
            
            if (count > k) {
                r = mid;
            } else if (count < k){
                l = mid;
            } else {
                return new int[]{x, y};
            }
        }
    }
    
    private int check(int[] arr, double max) {
        int count = 0;
        int n = arr.length;
        x = 0;
        y = 1;
        
        for (int i = 0, j = n - 1; i < n; i++) {
            while (j >= 0 && arr[i] > arr[n - 1 - j] * max) j--;
            count += (j + 1);
            
            // 将 x 和 y 更新为当前区间的最大值
            if (j >= 0 && x * arr[n - 1 - j] < y * arr[i]) {
                x = arr[i];
                y = arr[n - 1 - j];
            }
        }
        
        return count;
    }
}
