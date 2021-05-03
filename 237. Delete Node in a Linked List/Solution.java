/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        int num = node.val;
        while (node.next!= null) {
            if (node.next.next == null ) {
                if (node.val == num) {
                    node.val = node.next.val;
                    node.next = null;
                } else {
                    node = node.next;
                }
            } else {
                if (node.val == num) {
                    node.val = node.next.val;
                    node.next = node.next.next;
                    node = node.next;
                } else {
                    node = node.next;
                }
            }
        }
    }
}