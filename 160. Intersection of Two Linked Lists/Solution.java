/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        
        boolean A = false;
        boolean B = false;
        
        while (l1 != l2) {
            if (l1.next == null && A == false) {
                l1 = headB;
                A = true;
            } else if (l1.next == null && A == true){
               return null;
            } else {
                 l1 = l1.next;
            }
            
            if (l2.next == null && B == false) {
                l2 = headA;
                B = true;
            } else if(l2.next == null && B == true){
                return null;
            } else {
                l2 = l2.next;
            }
        }
        
        return l1;
    }
}
