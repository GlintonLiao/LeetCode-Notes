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
  public ListNode addTwoNumber(ListNode l1, ListNode l2) {
    ListNode root = new ListNode(0);
    ListNode result = root;
    int carry = 0;
    while (l1 != null && l2 != null) {
      carry += l1.val + l2.val;
      root.next = new ListNode(carry % 10);
      root = root.next;
      l1 = l1.next;
      l2 = l2.next;
      carry /= 10;
    }
    while (l1 != null) {
      carry += l1.val;
      root.next = new ListNode(carry % 10);
      root = root.next;
      l1 = l1.next;
      carry /= 10;
    }
    while (l2 != null) {
      carry += l2.val;
      root.next = new ListNode(carry % 10);
      root = root.next;
      l2 = l2.next;
      carry /= 10;
    }
    return result.next;
  }
}