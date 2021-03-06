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
    ListNode su = null;
    
    public ListNode reverseN(ListNode head, int s) {
        if (s == 1) {
            su = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, s - 1);
        head.next.next = head;
        head.next = su;
        return last;
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}