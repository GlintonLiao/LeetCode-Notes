class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // each element indicate how many passengers at this stop
        int[] stops = new int[1010];
        
        // traverse through the trips
        for (int[] t : trips) {
            // the end should be exclusive cause passengers will get off at this stop
            for (int i = t[1]; i < t[2]; i++) {
                stops[i] += t[0];
                // if any of the "current passengers" is greater than the capacity, then return false
                if (stops[i] > capacity) return false;
            }
        }
        return true;
    }
}