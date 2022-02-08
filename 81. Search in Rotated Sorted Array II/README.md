# 81. Search in Rotated Sorted Array II

There is an integer array `nums` sorted in non-decreasing order (not necessarily with **distinct** values).

Before being passed to your function, `nums` is rotated at an unknown pivot index `k` `(0 <= k < nums.length)` such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (**0-indexed**). For example, `[0,1,2,4,4,4,5,6,6,7]` might be rotated at pivot index `5` and become `[4,5,6,6,7,0,1,2,4,4]`.

Given the array `nums` after the rotation and an integer `target`, return `true` if target is in `nums`, or `false` if it is not in `nums`.

You must decrease the overall operation steps as much as possible.

#### Example 1

```
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
```

#### Example 2

```
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
```

## 解题思路

1. 找到原数组的起始点
2. 判断应该对哪一段二分，如果已经位于数组终点，则代表数组没有被旋转。
3. 二分查找

我以为我已经写得过于复杂了，想看看讨论区有什么优化解法，但发现他们好像想得更复杂...
