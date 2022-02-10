# 90. Subsets II

Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set).

The solution set **must not** contain duplicate subsets. Return the solution **in any order.**

#### Example 1

```
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
```

#### Example 2

```
Input: nums = [0]
Output: [[],[0]]
```

## 解题思路

组合式 + 去除重复值的 DFS

```java
// 组合式
for (int i = start; i < n; i++) {
  ...
  dfs(nums, i + 1);
  ...
}
```

```java
// 去除重复值
if (i > 1 && nums[i] == nums[i - 1] && st[i - 1] == 0) continue;
```

> 注意：使用去重方法的前提是**数组排好序**
