class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
      List<Integer> result = new ArrayList<>();
      String str = "123456789";
      for (int i = 2; i < 10; i ++) {
          for (int j = 0; i + j < 10; j++) {
              int t = Integer.parseInt(str.substring(j, i + j));
              if (t >= low) {
                  if (t <= high) {
                      result.add(t);
                  } else {
                      return result;
                  }
              }
          }
      }
      return result;
  }
}
