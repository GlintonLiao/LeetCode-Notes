# 24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

#### Example 1

![example img](https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg)

```
Input: head = [1,2,3,4]
Output: [2,1,4,3]
```

#### Example 2

```
Input: head = []
Output: []
```

#### Example 3

```
Input: head = [1]
Output: [1]
```

## 解题思路

时隔 8 个月再遇到这一题，可以非常自然地用递归来思考，对比起原来的题解真的是优雅了很多，也感受到了自己这大半年来的成长。

这题其实就是把每两个节点当成一组，只解决组内交换的问题，剩下部分按同一个逻辑递归处理即可。
