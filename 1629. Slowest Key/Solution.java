class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        int mi = 0;
        int n = releaseTimes.length;
        for (int i = 1; i < n; i++) {
            
            if (releaseTimes[i] - releaseTimes[i - 1] == max) {
                if (keysPressed.charAt(mi) < keysPressed.charAt(i)) {
                    mi = i;
                    max = releaseTimes[i] - releaseTimes[i - 1];
                }
            }
            
            if (releaseTimes[i] - releaseTimes[i - 1] > max) {
                mi = i;
                max = releaseTimes[i] - releaseTimes[i - 1];
            }
        }
        return keysPressed.charAt(mi);
    }
}
