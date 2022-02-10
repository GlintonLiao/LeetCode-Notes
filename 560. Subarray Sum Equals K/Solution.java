class Solution {
  public int subarraySum(int[] nums, int k) {
      int preSum = 0;
      int count = 0;
      int target = 0;
      
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      
      for (int n : nums) {
          preSum += n;
          target = preSum - k;
          
          if (map.containsKey(target)) count += map.get(target);
          
          map.put(preSum, map.getOrDefault(preSum, 0) + 1);
      }
      
      return count;
  }
}
