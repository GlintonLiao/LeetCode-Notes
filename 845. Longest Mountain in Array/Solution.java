class Solution {
    public int longestMountain(int[] arr) {
        int up = 0, down = 0;
        int res = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i] && down > 0 || arr[i - 1] == arr[i]) up = down = 0;
            if (arr[i - 1] < arr[i]) up++;
            if (arr[i - 1] > arr[i]) down++;
            if (up > 0 && down > 0 && res < up + down - 1) res = up + down + 1;
        }
        return res;
    }
}
