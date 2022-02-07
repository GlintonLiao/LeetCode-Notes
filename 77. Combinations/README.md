# 77. Combinations

## 题目描述

Given two integers `n` and `k`, return all possible combinations of `k` numbers out of the range `[1, n]`.

You may return the answer in any order.

#### Example 1

```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

## 解题思路

本题考查 `dfs` 去重，我的解法是传统 `dfs` 加上一个不断更新的起始点 `start`，选完一轮就把 `start + 1`。

但因为数组元素连续上升，所以其实更优的方法是直接 `dfs(int start, int n, int k)`，在递归中更新起点。

```java
private void dfs(int start, int n, int k) {

    if (k == 1) {
      res.add(new ArrayList<>(candidate));
      return;
    }

    for (int i = start; i < n; i++) {
        candidate.add(nums[i]);
        dfs(start + 1, n, k - 1);
        candidate.remove(candidate.size() - 1);
    }
}
```