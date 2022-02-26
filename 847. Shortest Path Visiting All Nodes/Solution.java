class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        
        Queue<Pair> q = new LinkedList<>();
        Set<Pair> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            int temp = 1 << i;
            set.add(new Pair(temp, i, 0));
            q.add(new Pair(temp, i, 1));
        }
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            
            if (curr.bitMask == (1 << N) - 1) {
                return curr.cost - 1;
            } else {
                int[] neighbors = graph[curr.curr];
                
                for (int v : neighbors) {
                    int bitMask = curr.bitMask;
                    bitMask = bitMask | (1 << v);
                    
                    Pair p = new Pair(bitMask, v, 0);
                    if (!set.contains(p)) {
                        q.add(new Pair(bitMask, v, curr.cost + 1));
                        set.add(p);
                    }
                }
            }
        }
        
        return -1;
    }
    
    class Pair {
        int bitMask;
        int curr;
        int cost;
        
        public Pair(int bit, int n, int c) {
            bitMask = bit;
            curr = n;
            cost = c;
        }
        
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return bitMask == p.bitMask && curr == p.curr && cost == p.cost;
        }
        
        public int hashCode() {
            return 1331 * bitMask + 7193 * curr + 727 * cost;
        }
    }
}
