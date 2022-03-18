class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        ArrayList<PII> list = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            for (int x : nums.get(i)) {
                list.add(new PII(x, i));
            }
        }
        
        Collections.sort(list);
        
        int l = 0, r = 0;
        int[] res = new int[2];
        boolean flag = false;
        int count = 0;
        int[] st = new int[k];
        
        while (r < list.size()) {
            if (st[list.get(r).y]++ == 0) {
                count++;
            }
            r++;
            
            while (count == k) {
                if (!flag || res[1] - res[0] > list.get(r - 1).x - list.get(l).x) {
                    res[0] = list.get(l).x;
                    res[1] = list.get(r - 1).x;
                    flag = true;
                }
                
                if (st[list.get(l).y]-- == 1) count--;
                l++;
            }
        }
        
        return res;
    }
    
    class PII implements Comparable<PII> {
        int x;
        int y;
        
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(PII p) {
            return Integer.compare(x, p.x);
        }
    }
}