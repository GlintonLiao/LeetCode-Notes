class FreqStack {
    
    Map<Integer, Integer> freq;
    PriorityQueue<Pair> queue;
    int idx;

    public FreqStack() {
        freq = new HashMap<>();
        queue = new PriorityQueue<>();
        idx = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int cnt = freq.get(val);
        queue.offer(new Pair(val, cnt, idx++));
    }
    
    public int pop() {
        Pair p = queue.poll();
        freq.put(p.val, freq.get(p.val) - 1);
        return p.val;
    }
    
    class Pair implements Comparable<Pair> {
        int val;
        int freq;
        int idx;
        
        public Pair(int val, int freq, int idx) {
            this.val = val;
            this.freq = freq;
            this.idx = idx;
        }
        
        public int compareTo(Pair p) {
            if (Integer.compare(p.freq, freq) == 0) {
                return Integer.compare(p.idx, idx);
            } else {
                return Integer.compare(p.freq, freq);
            }
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */