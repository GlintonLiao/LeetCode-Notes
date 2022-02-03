# 130. Surrounded Regions

## 题目描述

Given an `m` x `n` matrix `board` containing `'X'` and `'O'`, capture all regions that are 4-directionally surrounded by `'X'`.

A region is **captured** by flipping all `'O'`s into `'X'`s in that surrounded region.

#### Example 1:

![alt example img](https://assets.leetcode.com/uploads/2021/02/19/xogrid.jpg)

```
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
```

## 解题思路

对四条边 `dfs`，把所有能连上的数变为 `X`。

### 需要注意的地方

这道题有许多优化的技巧，因为一开始写完之后 Memory Limit Exceed 了，本来思路是没有问题的。

1. 这道题不需要单独开一个 `int[][] st` 数组，只需要把原矩阵对应值修改为一个别的字符就行。

2. 本题也不需要「恢复现场」，因为并不涉及组合，而只是要把目标数找出来。

3. 在 dfs 的过程中，尽量在一开始判断越界问题，然后跳出递归。

```java
// Bad
private void dfs(char[][] board, int i, int j) {
    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
      dfs(...); 
    }
}
```

```java
// Good
private void dfs(char[][] board, int i, int j) {
    if (i < 0 || i >= board.length || j < 0 || j <= board[0].length) return;
    dfs(...);
}
```

