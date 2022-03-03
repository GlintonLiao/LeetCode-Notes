# 413. Arithmetic Slices

An integer array is called arithmetic if it consists of **at least three elements** and if the difference between any two consecutive elements is the same.

+ For example, `[1,3,5,7,9]`, `[7,7,7,7]`, and `[3,-1,-5,-9]` are arithmetic sequences.

Given an integer array `nums`, return the number of arithmetic **subarrays** of `nums`.

A **subarray** is a contiguous subsequence of the array.

#### Example 1:

```
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
```

#### Example 2:

Input: nums = [1]
Output: 0
 
#### Constraints:

+ `1 <= nums.length <= 5000`
+ `-1000 <= nums[i] <= 1000`

## 解题思路

首先，等差数列必须有 `3` 个及以上元素，所以遍历的时候可以从 `2` 开始。

如果说满足要求，我们会给结果加上一个累加的值，因为窗口每扩展一位，合法的子串数量都会倍增

```
[1, 2, 3] -> cnt: 1
[1, 2, 3, 4] -> cnt: 3 == 1 + (1 + 1)
[1, 2, 3, 4, 5] -> cnt: 6 == 3 + ((1 + 1) + 1)
```

其实我们可以用动态规划的思想来解决这个问题。

`f[i]` 表示以 `i` 结尾的合法等差子串集合，则这个集合可以划分为：

1. 包含 `i` 的子串，等于`（当前合法串长度）- 2`

2. 不含 `i` 的子串，也就是 `f[i - 1]`

```java
// 状态转移方程
f[i] = f[i - 1] + (i - j + 1 - 2);
```
