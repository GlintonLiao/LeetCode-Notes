class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int t = 0;
            for (char c : w.toCharArray()) {
                t |= 1 << (c - 'a');
            }
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        for (String p : puzzles) {
            int mask = 0;
            int count = 0;
            
            for (char c : p.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            
            int k = mask;
            int first = 1 << (p.charAt(0) - 'a');
            while (k != 0) {
                if ((k & first) == first && map.containsKey(k)) {
                    count += map.get(k);
                }
                
                // key points
                k = mask & (k - 1);
            }
            res.add(count);
        }
        
        return res;
    }
}
