# 82. Remove Duplicates from Sorted List II

Given the `head` of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list **sorted** as well.


#### Example 1:

![example img](https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg)

```
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
```

#### Example 2:

```
Input: head = [1,1,1,2,3]
Output: [2,3]
``` 

#### Constraints:

+ The number of nodes in the list is in the range `[0, 300]`.
+ `-100 <= Node.val <= 100`
+ The list is guaranteed to be **sorted** in ascending order.

## 解题思路

用递归来思考这题，只要当前满足两者 val 不相同，直接递归处理它的 next；反之找到第一个 val 不同的 node，返回递归处理这个 node 的结果。
