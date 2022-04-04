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
    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }
        
        int idx = 1;
        p = head;
        ListNode n1 = null, n2 = null;
        while (p != null) {
            if (idx == k) {
                n1 = p;
            }
            if (idx == length - k + 1) {
                n2 = p;
            }
            idx++;
            p = p.next;
        }
        
        /*
        n1.val ^= n2.val;
        n2.val ^= n1.val;
        n1.val ^= n2.val;
        */
        
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        
        return head;
    }
}
