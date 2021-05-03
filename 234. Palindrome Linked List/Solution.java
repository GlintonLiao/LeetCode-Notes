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
    public boolean isPalindrome(ListNode head) {
        
        //reverse the List
        ListNode p = head.next;
        ListNode newHead = new ListNode(head.val);
        
        while(p != null) {
            ListNode curr = new ListNode(p.val);
            curr.next = newHead;
            newHead = curr;
            p = p.next;
        }
        
        //compare two lists
        ListNode l1 = head;
        ListNode l2 = newHead;
        
        while(l1 != null) {
            if (l1.val == l2.val) {
                l1 = l1.next;
                l2 = l2.next;
            } else {
                return false;
            }
        }
        return true;
        
    }
}
