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
    public ListNode rotateRight (ListNode head, int k) {
        if (head == null) return head;
        ListNode curr = head;
        int length = 0;
        
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }
        
        length++;
        if (length == 1) return head;
        
        k %= length;
        if (k == 0) return head;
        curr.next = head;
        curr = head;
        
        int cut = length - k;
        while (--cut > 0) curr = curr.next;
        head = curr.next;
        curr.next = null;
        
        return head;
    }
}
