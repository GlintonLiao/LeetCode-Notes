class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
      int[] selected = new int[strs.length];
      List<List<String>> result = new ArrayList<>();
      List<String> candidate = new ArrayList<>();
      
      for (int i = 0; i < strs.length; i++) {
          
          if (selected[i] == 1) continue;
          selected[i] = 1;
          candidate.add(strs[i]);
      
          for (int j = 0; j < strs.length; j++) {
              if (selected[j] == 0) {
                  if (check(strs[i], strs[j])) {
                      selected[j] = 1;
                      candidate.add(strs[j]);
                  }
              }
          }
      
          result.add(new ArrayList<String>(candidate));
          candidate.clear();
      }
      
      return result;
  }
  
  private boolean check(String a, String b) {
      
      if (a.length() != b.length()) return false;
      char[] arr1 = a.toCharArray();
      char[] arr2 = b.toCharArray();
      
      Arrays.sort(arr1);
      Arrays.sort(arr2);
      return Arrays.equals(arr1, arr2);
  }
}
