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

 // MergeSort for linkedlist
class Solution {
  public ListNode sortList(ListNode head) {
      if (head == null || head.next == null) return head;
      
      ListNode fast = head;
      ListNode slow = head;
      ListNode mark = null;
      
      while (fast != null && fast.next != null) {
          mark = slow;
          slow = slow.next;
          fast = fast.next.next;
      }
      
      mark.next = null;
      
      ListNode h1 = sortList(head);
      ListNode h2 = sortList(slow);
      
      return merge(h1, h2);
  }
  private ListNode merge(ListNode h1, ListNode h2) {
      ListNode result = new ListNode();
      ListNode head = result;
      
      while (h1 != null && h2 != null) {
          if (h1.val < h2.val) {
              head.next = h1;
              h1 = h1.next;
          } else {
              head.next = h2;
              h2 = h2.next;
          }
          head = head.next;
      }
      
      if (h1 != null) {
          head.next = h1;
      }
      if (h2 != null) {
          head.next = h2;
      }
      
      return result.next;
  }
}