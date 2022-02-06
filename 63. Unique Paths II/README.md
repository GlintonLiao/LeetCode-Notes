# 63. Unique Paths II

A robot is located at the top-left corner of a `m x n` grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as `1` and `0` respectively in the grid.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg)

```
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
```

## 解题思路

经典三角形模型动态规划

### 状态表示

#### 集合表示

`f[i][j]` 表示以 `[i, j]` 结尾的所有路径走法。

#### 集合属性

路径的个数

### 状态计算

对于每个点，都有两条路，从上方来和从左边来，即 `f[i - 1][j]` 和 `f[i][j - 1]`，因为有限制，所以有限制的地方把路径清零。

最终状态转移方程为：

```java
if (grid[i][j] == 1) {
  f[i][j] = 0;
} else {
  f[i][j] = f[i - 1][j] + f[i][j - 1];
}
```