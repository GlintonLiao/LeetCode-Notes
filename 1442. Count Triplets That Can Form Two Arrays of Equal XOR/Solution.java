class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    res += (j - i);
                }
            }
        }
        return res;
    }
}
