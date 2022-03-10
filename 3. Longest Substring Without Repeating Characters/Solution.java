class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, n = s.length();
        
        for (int i = 0, j = 0; i < n; i += 1) {
            
            // if same char is found, then move the pointer j to the right of the i
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        
        return max;
    }
}