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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        
        int carry = 0;
        ListNode res = new ListNode();
        ListNode p = res;
        
        while (r1 != null && r2 != null) {
            carry += r1.val + r2.val;
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry /= 10;
            r1 = r1.next;
            r2 = r2.next;
        }
        
        while (r1 != null) {
            carry += r1.val;
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry /= 10;
            r1 = r1.next;
        }
        
        while (r2 != null) {
            carry += r2.val;
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry /= 10;
            r2 = r2.next;
        }
        
        if (carry != 0) {
            p.next = new ListNode(carry);
            p = p.next;
        }
        
        return reverse(res.next);
    }
    
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode next = node.next;
        node.next = null;
        ListNode newHead = reverse(next);
        next.next = node;
        return newHead;
    }
}
