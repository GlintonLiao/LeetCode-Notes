class Solution {
  public int maxEvents(int[][] events) {
      if (events.length == 1) return 1;
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      Arrays.sort(events, (a, b) -> compare(a, b));
      
      int i = 0, count = 0;
      
      for (int d = 0; d <= 100000; d++) {
          
          // add endpoint of event which startpoint is at d
          while (i < events.length && events[i][0] == d) {
              pq.offer(events[i++][1]);
          }
          
          // remove event that already been closed
          while (!pq.isEmpty() && pq.peek() < d) {
              pq.poll();
          }
          
          // remove one event and add one to the count
          if (!pq.isEmpty()) {
              pq.poll();
              count++;
          }
          
          // done and quit iteration
          if (pq.isEmpty() && i >= events.length) break;
      }
      
      return count;
  }
  
  private int compare(int[] a, int[] b) {
      if (a[0] == b[0]) {
          if (a[1] == b[1]) {
              return 0;
          } else if (a[1] > b[1]) {
              return 1;
          } else {
              return -1;
          }
      } else {
          if (a[0] > b[0]) {
              return 1;
          } else {
              return -1;
          }
      }
  }
}
