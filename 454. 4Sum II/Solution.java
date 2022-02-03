class Solution {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      Map<Integer, Integer> sums = new HashMap<>();
      int result = 0;
      for(int i : nums1){
          for(int j : nums2){
              int sum = i + j;
              sums.put(sum, sums.getOrDefault(sum, 0) + 1);
          }
      }
      for(int i : nums3){
          for(int j : nums4){
              result += sums.getOrDefault(-(i+j), 0);
          }
      }
      return result;
  }
}
