class Solution {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      List<int[]> res = new LinkedList<>();
      int i = 0, j = 0;
      int n1 = firstList.length, n2 = secondList.length;
      int l = -1, r = -1;
      while (i < n1 && j < n2) {
          // System.out.println(i + " " + j + " " + l + " " + r);
          if (firstList[i][0] <= secondList[j][0]) {
              if (r >= firstList[i][1]) {
                  res.add(new int[]{firstList[i][0], firstList[i][1]});
              } else if (r >= firstList[i][0] && r <= firstList[i][1]) {
                  res.add(new int[]{firstList[i][0], r});
                  l = firstList[i][0];
                  r = firstList[i][1];
              } else {
                  l = firstList[i][0];
                  r = firstList[i][1];
              }
              i++;
          } else {
              if (r >= secondList[j][1]) {
                  res.add(new int[]{secondList[j][0], secondList[j][1]});
              } else if (r >= secondList[j][0] && r <= secondList[j][1]) {
                  res.add(new int[]{secondList[j][0], r});
                  l = secondList[j][0];
                  r = secondList[j][1];
              } else {
                  l = secondList[j][0];
                  r = secondList[j][1];
              }
              j++;
          }
      }
      
      while (j < n2) {
          if (r >= secondList[j][1]) {
              res.add(new int[]{secondList[j][0], secondList[j][1]});
          } else if (r >= secondList[j][0] && r <= secondList[j][1]) {
              res.add(new int[]{secondList[j][0], r});
              l = secondList[j][0];
              r = secondList[j][1];
          } else {
              l = secondList[j][0];
              r = secondList[j][1];
          }
          j++;
      }
      
      while (i < n1) {
          if (r >= firstList[i][1]) {
              res.add(new int[]{firstList[i][0], firstList[i][1]});
          } else if (r >= firstList[i][0] && r <= firstList[i][1]) {
              res.add(new int[]{firstList[i][0], r});
              l = firstList[i][0];
              r = firstList[i][1];
          } else {
              l = firstList[i][0];
              r = firstList[i][1];
          }
          i++;
      }
  
      return res.toArray(new int[0][]);
  }
}
