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
  public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode n1 = head;
      ListNode n2 = head.next;
      
      n1.next = swapPairs(n2.next);
      n2.next = n1;
      
      return n2;
  }
}