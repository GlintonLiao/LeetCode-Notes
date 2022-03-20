class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n1 = tops[0];
        int n2 = bottoms[0];
        int cnt1 = 0, cnt2 = 0;
        
        cnt1 += (n1 == tops[1] || n1 == bottoms[1]) ? 1 : 0;
        cnt2 += (n2 == tops[1] || n2 == bottoms[1]) ? 1 : 0;
        
        if (cnt1 != cnt2) {
            int n = cnt1 > cnt2 ? n1 : n2;
            return count(tops, bottoms, n);
        } else {
            if (cnt1 == 0) {
                return -1;
            } else {
                return Math.max(count(tops, bottoms, n1), count(tops, bottoms, n2));
            }
        }
    }
    
    private int count(int[] tops, int[] bottoms, int n) {
        int t = 0, b = 0, bal = 0;
        for (int i = 0; i < tops.length; i++) {
            if (n == tops[i] && n == bottoms[i]) {
                t++;
                b++;
                bal++;
            } else if (n == tops[i]) {
                t++;
            } else if (n == bottoms[i]){
                b++;
            } else {
                return -1;
            }
        }
        
        return (t > b) ? b - bal : t - bal;
    }
}
