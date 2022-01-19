class Solution {
  public int reverse(int x) {
      String str = String.valueOf(x);
      char[] arr = str.toCharArray();
      int l = arr[0] == '-' ? 1 : 0;
      int r = arr.length - 1;
      while (l < r) {
          
          // just to improve the running time...
          if (arr[l] == arr[r]) {
              l++;
              r--;
              continue;
          }
          
          char temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
          l++;
          r--;
      }
      
      String charString = String.valueOf(arr);
      
      try {
          int result = Integer.parseInt(charString);
          return result;
      } catch (Exception e) {
          return 0;
      }
  }
}
