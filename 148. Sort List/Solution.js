/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
 var sortList = function(head) {
  if (head == null || head.next == null) return head
  
  let slow = head
  let fast = head
  let mark = null
  while (fast != null && fast.next != null) {
      mark = slow
      slow = slow.next
      fast = fast.next.next
  }
  mark.next = null
  
  let l1 = sortList(head)
  let l2 = sortList(slow)
  
  return merge(l1, l2)
};

var merge = function(l1, l2) {
  let result = new ListNode()
  let head = result
  while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
          head.next = l1
          l1 = l1.next
      } else {
          head.next = l2
          l2 = l2.next
      }
      head = head.next
  }
  
  if (l1 != null) {
      head.next = l1
  }
  if (l2 != null) {
      head.next = l2
  }
  
  return result.next
}
