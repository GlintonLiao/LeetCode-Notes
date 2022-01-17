class Solution {
  public boolean wordPattern(String pattern, String s) {
      char[] p = pattern.toCharArray();
      String[] str = s.split(" ");
      HashMap<Character, String> map = new HashMap<>();
      
      if (p.length != str.length) return false;
      
      for (int i = 0; i < p.length; i++) {
          if (!map.containsKey(p[i])) {
              if (map.containsValue(str[i])) return false;
              map.put(p[i], str[i]);
          } else {
              if (!map.get(p[i]).equals(str[i])) {
                  return false;
              }
          }
      }
      return true;
  }
}
