class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new LinkedList<>();
        int n = security.length;
        int[] ni = new int[n];
        int[] nd = new int[n];
        
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                ni[i] = ni[i - 1] + 1;
            } else {
                ni[i] = 0;
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                nd[i] = nd[i + 1] + 1;
            } else {
                nd[i] = 0;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i - time < 0 || i + time >= n) continue;
            if (ni[i] >= time && nd[i] >= time) res.add(i);
        }
        
        return res;
    }
}
