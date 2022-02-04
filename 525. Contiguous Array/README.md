# 525. Contiguous Array

## 题目描述

Given a binary array `nums`, return the maximum length of a contiguous subarray with an equal number of `0` and `1`.

#### Example 1

```
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
```

#### Example 2

```
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
```

## 解题思路

转换一下思维，我们可以把「相同数量的 0 和 1」转化为「相同数量的 -1 和 1」，也就是「和为 0」的最长子数组。

所以，本题其实是一个前缀和问题。

先求出每一项的前缀和，然后对这个前缀和数组做一个 `twoSum` 查找（更准确地讲是 `twoMinus`），即查找**前缀和相同的两个下标**之间的**最远距离**。

> #### 注意点
> 在制作 `twoMinus` 的 `HashMap` 时，需要初始化 `map.put(0, -1)`，因为有可能最后一项的前缀和为 `0`，代表着整个数组的前缀和就是 `0`，此时最大长度就是数组的长度 `sum.length = (sum.length - 1) - (-1 - 1) + 1`，即`最后一项的下标 - (第一项的下标 - 1) + 1`，而第一项的下标因为数组的遍历还没开始，所以是 `-1`。

在此复习一下前缀和的知识。如果我们要知道 l ~ r 的和，`nums[l] + ... + nums[r] == sum[r] - sum[l - 1]`

所以，`twoMinus` 操作找到的下标实际上是 `r` 和 `l - 1`，他们之间的距离就是 `r - (l - 1) + 1`，恰好就是 `r - l`。