# 37. Sudoku Solver

## 题目描述

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy **all of the following rules**:

1. Each of the digits `1-9` must occur exactly once in each row.
2. Each of the digits `1-9` must occur exactly once in each column.
3. Each of the digits `1-9` must occur exactly once in each of the 9 `3x3` sub-boxes of the grid.

The `'.'` character indicates empty cells.

#### Example 1

![example img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

```
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
```

## 解题思路

直接暴力 `dfs`，不符合条件就 `return false`，掐断这条路。

几个原则：

1. 遍历完一行 `(j == n)`，就从下一行开始 `(i + 1, 0)`
2. 遍历完最后一行 `(i == n)`，说明合法, `return true`
3. 如果 `(i, j)` 有数字，就 `dfs` 下一个 `(i, j + 1)`
4. 对于每个 `'.'`，遍历 `'1'~'9'`，能填就往里填，`dfs` 下一个字符，`return false` 就恢复现场，`return true` 就直接退出 `dfs` ，不恢复现场。

#### 子矩阵的遍历

```java
board[(i / 3) * 3 + x / 3][(j / 3) * 3 + x % 3];
```

`(i / 3) * 3 `和 `(j / 3) * 3` 的意思是找出 `i, j` 所属的子矩阵，再把这个点映射到子矩阵的起点。

随后映射到具体的位置。
```java
// 1 ～ 9 矩阵映射
x / 3 （0,1,2 -> 0; 3,4,5 -> 1; 6,7,8 -> 2）
x % 3 （0,3,6 -> 0; 1,4,7 -> 1; 2,5,8 -> 2)
```