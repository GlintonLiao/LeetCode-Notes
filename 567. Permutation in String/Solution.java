class Solution {
  public boolean checkInclusion(String s1, String s2) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s1.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }
      
      int count = map.size();
      
      int l = 0, r = 0, n = s2.length(), sLen = s1.length();
      
      while (r < n) {
          char c = s2.charAt(r);
          if (map.containsKey(c)) {
              map.put(c, map.get(c) - 1);
              if (map.get(c) == 0) count--;
          }
          
          r++;
          
          while (count == 0) {
              char temp = s2.charAt(l);
              if (map.containsKey(temp)) {
                  map.put(temp, map.get(temp) + 1);
                  if (map.get(temp) > 0) count++;
              }
              
              if (r - l == sLen) return true;
              
              l++;
          }
      }
      
      return false;
  }
}
