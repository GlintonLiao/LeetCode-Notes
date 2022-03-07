class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, r = arr[arr.length - 1];
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(arr, mid) <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int curr = l;
        
        l = 1; 
        r = arr[arr.length - 1];
        while (l < r) {
            int mid = l + r >> 1;
            if (check(arr, mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        int abs1 = Math.abs(check(arr, curr) - target);
        int abs2 = Math.abs(check(arr, l) - target);
        
        return abs1 <= abs2 ? curr : l; 
    }
    
    private int check(int[] arr, int max) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < max) {
                sum += arr[i];
            } else {
                sum += max * (arr.length - i);
                break;
            }
        }
        return sum;
    }
}
