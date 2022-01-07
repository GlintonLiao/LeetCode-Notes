import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

  int N = 100010;
  int[] arr = new int[N];
  int index = 0;

  public Solution(ListNode head) {
      while (head != null) {
        arr[index++] = head.val;
        head = head.next;
      }
  }
  
  public int getRandom() {
      Random rand = new Random();
      return arr[rand.nextInt(index)];
  }
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(head);
* int param_1 = obj.getRandom();
*/
