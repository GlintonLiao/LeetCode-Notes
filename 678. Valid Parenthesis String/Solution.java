/**
 * 通配符 * 既可以向左匹配 也可以向右匹配
 * cmin 表示的是最少可以有多少左括号
 * 每一次匹配时，如果 cmax 大于 0 但 cmin 小于 0，证明通配符的左边没有左括号了
 */

class Solution {
  public boolean checkValidString(String s) {
      int cmax = 0, cmin = 0;
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '(') {
              cmax++;
              cmin++;
          } else if (s.charAt(i) == ')') {
              cmax--;
              cmin--;
          } else {
              cmax++;
              cmin--;
          }
          if (cmax < 0) return false;
          cmin = Math.max(cmin, 0);
      }
      return cmin == 0;
  }
}