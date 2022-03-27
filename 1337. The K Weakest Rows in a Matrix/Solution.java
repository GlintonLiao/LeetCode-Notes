class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int m = mat.length;
        int n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            int[] tmp = mat[i];
            int l = 0, r = tmp.length;
            while (l < r) {
                int mid = l + r >> 1;
                if (tmp[mid] == 0) 
                    r = mid;
                else 
                    l = mid + 1;
            }
            // System.out.println(l + " " + i);
            q.offer(new Pair(l, i));
        }
        
        int[] res = new int[k];
        int idx = 0;
        while (k-- > 0) {
            res[idx++] = q.poll().val;
        }
        return res;
    }
    
    class Pair implements Comparable<Pair> {
        int cnt;
        int val;
        
        public Pair(int cnt, int val) {
            this.cnt = cnt;
            this.val = val;
        }
        
        @Override
        public int compareTo(Pair p) {
            if (cnt != p.cnt) 
                return Integer.compare(cnt, p.cnt);
            else
                return Integer.compare(val, p.val);
        }
    }
}