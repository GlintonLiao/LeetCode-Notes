class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        // last appearence position
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, i);
        }
    
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (i > r) {
                res.add(r - l + 1);
                l = i;
                r = i;
            }
            
            int last = map.get(s.charAt(i));
            if (last > r) {
                r = last;
            } 
        }
        res.add(r - l + 1);
        return res;
    }
}
