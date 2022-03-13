class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        String res = "";
        if (tLen > sLen) return res;
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = map.size();
        int l = 0, r = 0;
        
        while (r < sLen) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            
            r++;
            
            while (count == 0) {
                char temp = s.charAt(l);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) count++;
                }
                
                if (r - l < res.length() || res.equals("")) res = s.substring(l, r);
                
                l++;
            }
        }
        
        return res;
    }
}
