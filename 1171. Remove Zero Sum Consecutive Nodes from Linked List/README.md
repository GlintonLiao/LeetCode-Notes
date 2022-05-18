# 1171. Remove Zero Sum Consecutive Nodes from Linked List

Given the `head` of a linked list, we repeatedly delete consecutive sequences of nodes that sum to `0` until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

(Note that in the examples below, all sequences are serializations of `ListNode` objects.)

#### Example 1:

```
Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
```

#### Example 2:

```
Input: head = [1,2,3,-3,4]
Output: [1,2,4]
```

#### Example 3:

```
Input: head = [1,2,3,-3,-2]
Output: [1]
``` 

#### Constraints:

+ The given linked list will contain between 1 and 1000 nodes.
+ Each node in the linked list has -1000 <= node.val <= 1000.

## 解题思路

子串的和为 0，意味着这一段的起点和终点的前缀和是同一个数，所以我们可以用一个 map 来维护前缀和和出现的位置。
