class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 0, r = position[position.length - 1] - position[0];
        while (l < r) {
            int mid = l + r + 1>> 1;
            if (canPlace(position, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    private boolean canPlace(int[] p, int m, int dis) {
        int i = 0, j = 0;
        while (m-- > 1) {
            while (p[j] - p[i] < dis) {
                j++;
                if (j >= p.length) return false;
            }
            i = j;
        }
        return true;
    }
}
