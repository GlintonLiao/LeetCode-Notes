# 662. Maximum Width of Binary Tree

Given the `root` of a binary tree, return the **maximum width** of the given tree.

The **maximum width** of a tree is the maximum **width** among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is **guaranteed** that the answer will in the range of **32-bit** signed integer.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2021/05/03/width1-tree.jpg)

```
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
```

#### Example 2

![example](https://assets.leetcode.com/uploads/2021/05/03/width2-tree.jpg)

```
Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
```

#### Example 3

![example img](https://assets.leetcode.com/uploads/2021/05/03/width3-tree.jpg)

```
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
```

#### Constraints

+ The number of nodes in the tree is in the range `[1, 3000]`.
+ `-100 <= Node.val <= 100`

## 解题思路

BFS，使用 level 来标记层数，注意题意是包含层数内的 null。也就是说计算的是完全二叉树的最后一层的元素数量。

用数组来表示一个完全二叉树，节点 `i` 的左节点就是 `2 * i`，右节点就是 `2 * i + 1`。

所以我们可以使用前序遍历的方式，当第一次来到这一层，就把节点坐标（这一层的最左端）存好，然后 update 当前点和左节点之间的距离最大值。
