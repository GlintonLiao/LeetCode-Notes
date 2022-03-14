class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int len = s.length();
        int res = 0;
        int maxChar = 0;
        
        while (j < len) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxChar = Math.max(maxChar, map.get(c));
            j++;
            
            if (j - i - maxChar > k) {
                char t = s.charAt(i);
                map.put(t, map.get(t) - 1);                
                i++;
            }
            
            res = Math.max(res, j - i);
        }
        
        return res;
    } 
}