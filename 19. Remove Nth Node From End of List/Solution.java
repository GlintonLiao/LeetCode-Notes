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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {return null;}
        if (head == null) {return null;}
        
        ListNode p = head;
        int size = 0;
        while (p!= null) {
            p = p.next;
            size += 1;
        }
        
        int index = size - n + 1;
        ListNode newP = head;
        while (index > 2) {
            newP = newP.next;
            index -= 1;
        }
        
        if (index == 1) {
            head = head.next;
            return head;
        }
        
        if (newP.next.next == null) {
            newP.next = null;
            return head;
        }
        
        newP.next = newP.next.next;
        return head;
        
    }
}
