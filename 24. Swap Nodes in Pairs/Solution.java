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
        if (head == null) {return null;}
        if (head.next == null) {return head;}
        
        ListNode p = head;
        int isSwap = 1;

        while (p.next != null) {
            if (isSwap == 1) {
                int temp = p.next.val;
                p.next.val = p.val;
                p.val = temp;
                p = p.next;
                isSwap = 0;
            } else {
                p = p.next;
                isSwap = 1;
            }
        }
        
        return head;
    }
}
