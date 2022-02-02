class Solution {
  public List<Integer> findAnagrams(String s, String p) {
      int sLen = s.length();
      int pLen = p.length();
      List<Integer> result = new ArrayList<>();
      
      if (sLen < pLen) return result;
      
      Map<Character, Integer> map = new HashMap<>();
      for (char c : p.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }
      
      // count 维护的是「需要匹配的不同字母的数量」
      // count == 0 时，代表 map 里面所有字符对应数值都 <= 0 了
      int count = map.size();
      int l = 0, r = 0;
      
      while (r < sLen) {
          
          char c = s.charAt(r);
          if (map.containsKey(c)) {
              map.put(c, map.get(c) - 1);
              if (map.get(c) == 0) count--;
          }
          
          r++;
          
          // 只有「需要匹配的不同字母的数量」都为 0 时，才会进入这个循环
          while (count == 0) {
              char temp = s.charAt(l);
              if (map.containsKey(temp)) {
                  map.put(temp, map.get(temp) + 1);
                  // 这个地方可能会出现某个字符对应值为负数或 0 的情况
                  // 说明「窗口内的字符比需要匹配的字符多」，这种情况不加 count
                  // 而只是将这个字符推出窗口
                  if (map.get(temp) > 0) count++;
              }
              
              if (r - l == pLen) {
                  result.add(l);
              }
              
              l++;
          }
          
      }
      
      return result;
  }
}