class Solution {
    public int closestToTarget(int[] arr, int t) {
        int m = arr.length, res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(arr[i]);
            for (int n : set) {
                tmp.add(n & arr[i]);
            }
            for (int n : tmp) res = Math.min(res, Math.abs(n - t));
            set = tmp;
        }
        return res;
    }
}