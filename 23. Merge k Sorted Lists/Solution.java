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
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists.length == 0) return null;
      if (lists.length == 1) return lists[0];
      
      return merge(lists, 0, lists.length - 1);
      
  }
  
  private ListNode merge(ListNode[] lists, int l, int r) {
      
      if (l == r) return lists[l];
      if (r - l == 1) {
          ListNode l1 = lists[l];
          ListNode l2 = lists[r];
          
          ListNode head = new ListNode();
          ListNode result = head;
          
          while (l1 != null && l2 != null) {
              if (l1.val <= l2.val) {
                  head.next = l1;
                  l1 = l1.next;
              } else {
                  head.next = l2;
                  l2 = l2.next;
              }
              head = head.next;
          }
          
          if (l1 != null) {
              head.next = l1;
          }
          
          if (l2 != null) {
              head.next = l2;
          }
          
          return result.next;
      }
      
      int mid = l + r >> 1;
      ListNode n1 = merge(lists, l, mid);
      ListNode n2 = merge(lists, mid + 1, r);
      
      return merge(new ListNode[]{n1, n2}, 0, 1);
  }
}
