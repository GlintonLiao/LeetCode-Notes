class Solution {
  public int findMaxLength(int[] nums) {
      int[] sum = new int[nums.length];
      sum[0] = nums[0] == 0 ? -1 : 1;
      
      for (int i = 1; i < nums.length; i++) {
          sum[i] = sum[i - 1] + (nums[i] == 0 ? -1 : 1);
      }
      
      int max = 0;
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, -1);
      for (int i = 0; i < sum.length; i++) {
          if (map.containsKey(sum[i])) {
              max = Math.max(max, i - map.get(sum[i]));
          } else {
              map.put(sum[i], i);
          }
      }
      
      return max;
  }
}
