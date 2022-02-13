# 120. Triangle

Given a `triangle` array, return the *minimum* path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index `i` on the current row, you may move to either index `i` or index `i` + `1` on the next row.

#### Example 1

```
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
```

#### Example 2

```
Input: triangle = [[-10]]
Output: -10
```

## 解题思路

经典三角形模型动态规划

### 状态表示

**集合表示**

`f[i][j]` 表示以 `[i, j]` 为结尾的所有路径的集合

**集合属性**

路径之和的最小值

### 状态计算

每个点都只能对应两条路径，要么是上面下来的，要么是左上下来的。

状态转移方程为

```java
f[i, j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + w[i][j];
```
因为是求最小值，所以需要初始化 `f` 数组的值为正无穷。

答案就是 `f` 数组最后一排的最小值。
