# 79. Word Search

Given an `m x n` grid of characters board and a string `word`, return `true` if `word` exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2020/11/04/word2.jpg)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

#### Example 2

![example img](https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```

#### Example 3

![example img](https://assets.leetcode.com/uploads/2020/10/15/word3.jpg)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
```

## 解题思路

如果是返回布尔值的 DFS，有如下模板：

```java
if (符合条件) return true;
if (不符合条件) return false;

// 设定当前条件
matrix[i][j] = ...;

boolean result = dfs(可能性1) || dfs(可能性2) || ...;

// 恢复现场
matrix[i][j] = ...;

return result;
```
