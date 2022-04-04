# 1721. Swapping Nodes in a Linked List

You are given the `head` of a linked list, and an integer `k`.

Return the `head` of the linked list after **swapping** the values of the `kth` node from the beginning and the kth node from the end (the list is **1-indexed**).

 

#### Example 1:

![example img](https://assets.leetcode.com/uploads/2020/09/21/linked1.jpg)

```
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
```

#### Example 2:

```
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
``` 

#### Constraints:

+ The number of nodes in the list is `n`.
+ `1 <= k <= n <= 10^5`
+ `0 <= Node.val <= 100`

## 解题思路

有两种思路，一是先遍历一次找出长度，然后交换第 `k` 和第 `length - k + 1` 个的数值。

还有一种思路是，遍历到第 `k` 个时，记录下当前的这个节点，然后使另一个节点从头开始，双指针同时移动，当右指针指向队尾时，左指针就是 `length - k + 1` 个元素了。
