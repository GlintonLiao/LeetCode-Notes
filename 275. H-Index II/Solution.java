class Solution {
  public int hIndex(int[] citations) {
      int l = 0, r = citations.length - 1;
      
      while (l < r) {
          int mid = l + r >> 1;
          if (citations[mid] >= citations.length - mid) {
              r = mid;
          } else {
              l = mid + 1;
          }
      }
      
      // 二分一定有解，但原题不一定有解
      if (citations.length - l > citations[l]) return 0;
      
      return citations.length - l;
  }
}