class Solution {
  public boolean validMountainArray(int[] arr) {
      if (arr.length < 3) return false;
      int l = 0, r = arr.length - 1;
      
      while (l < arr.length - 1 && arr[l] < arr[l + 1]) l ++;
      while (r > 0 && arr[r] < arr[r - 1]) r --;
          
      if (l < r || l == arr.length - 1 || r == 0) return false;
      
      return true;
  }
}
