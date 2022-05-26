class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new LinkedList<>();
        int m = rounds.length;
        if (rounds[0] > rounds[m - 1]) {
            for (int i = 1; i <= rounds[m - 1]; i++) {
                res.add(i);
            }
            for (int i = rounds[0]; i <= n; i++) {
                res.add(i);
            }
        } else {
            for (int i = rounds[0]; i <= rounds[m - 1]; i++) {
                res.add(i);
            }
        }
        return res;
    }
}
