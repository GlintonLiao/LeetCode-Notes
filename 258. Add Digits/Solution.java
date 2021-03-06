class Solution {
  public int addDigits(int num) {
      if (num < 10) return num;
      
      int carry = 0;
      while (num > 0) {
          carry += num % 10;
          num /= 10;
      }
      
      return addDigits(carry);
  }
}
