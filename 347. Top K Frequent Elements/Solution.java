class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0;
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        // two pointers, add cnt to the priority queue
        while (j < n) {
            while (j < n && nums[j] == nums[i]) j++;
            pq.offer(new Pair(nums[i], j - i));
            i = j;
        }
        
        // get the top k elements
        int[] res = new int[k];
        for (int x = 0; x < k; x++) {
            res[x] = pq.poll().val;
        }
        return res;
    }
    
    class Pair implements Comparable<Pair> {
        int val;
        int freq;
        
        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(p.freq, this.freq);
        }
    }
}
