class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] b : boxTypes) {
            if (b[0] <= truckSize) {
                truckSize -= b[0];
                res += b[1] * b[0];
            } else {
                if (truckSize > 0)
                    res += truckSize * b[1];
                break;
            }
        }
        return res;
    }
}