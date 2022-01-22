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
  public ListNode reverseKGroup(ListNode head, int k) {
      ListNode ptr = head;
      int count = 0;
      
      while (ptr != null) {
          ptr = ptr.next;
          count ++;
      }
      
      int cntToReverse = count / k;
      int ori = k;
  
      return reverse(head, k, ori, cntToReverse);
  }
  
  private ListNode reverse(ListNode head, int k, int ori, int count) {
      if (head.next == null) return head;
      
      if (k != 1) {
          ListNode next = head.next;
          ListNode newHead = reverse(head.next, k - 1, ori, count);
          head.next = next.next;
          next.next = head;
          return newHead;
      } else {
          if (count == 1) return head;
          count --;
          head.next = reverse(head.next, ori, ori, count);
          return head;
      }
      
  }
}
