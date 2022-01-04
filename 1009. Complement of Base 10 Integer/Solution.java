class Solution {
  public int bitwiseComplement(int n) {
    String str = Integer.toBinaryString(n);

    // create a StringBuilder
    StringBuilder sb = new StringBuilder(str);
    // for each character, 0 -> 1, 1 -> 0
    for (int i = 0; i < sb.length(); i++) {
      sb.setCharAt(i, sb.charAt(i) == '1' ? '0' : '1');
    }
    str = sb.toString();
    // 转化为 10 进制
    return Integer.valueOf(str, 2);
  }
}