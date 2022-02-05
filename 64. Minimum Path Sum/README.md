# 64. Minimum Path Sum

## 题目描述

Given a `m x n` `grid` filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg)

```
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
```

## 解题思路

经典三角形模型的动态规划

### 状态表示

#### 集合表示

`f[i][j]` 表示以 `grid[i][j]` 结尾的所有路径。

#### 集合属性

路径数值之和的最小值。

### 状态计算

对于每一个点来说，最后一步到达这个点的方式都只有只有两种：

1. 从上方过来：
```java
f[i][j] = f[i - 1][j] + grid[i][j];
```

2. 从左边过来：
``` java
f[i][j] = f[i][j - 1] + grid[i][j];
```

所以，取这两种情况更小的那个，就是 `f[i][j]` 了。

状态转移方程：
```java
f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
```

最后输出最后一项 `f[i - 1][j - 1]` 即可。
