class Solution {
  public int trap(int[] height) {
      int[] maxL = new int[height.length];
      int[] maxR = new int[height.length];
      
      maxL[0] = height[0];
      maxR[height.length - 1] = height[height.length - 1];
      
      int idx = 0;
      while (idx < height.length - 1) {
          maxL[idx + 1] = Math.max(maxL[idx], height[idx + 1]);
          idx++;
      }
      
      while (idx > 0) {
          maxR[idx - 1] = Math.max(maxR[idx], height[idx - 1]);
          idx--;
      }
      
      int result = 0;
      for (int i = 0; i < height.length; i++) {
          result += Math.min(maxL[i], maxR[i]) - height[i];
      }
      
      return result;
  }
}
