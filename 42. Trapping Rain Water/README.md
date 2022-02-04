# 42. Trapping Rain Water

## 题目描述

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

## 解题思路

做两个 `DP` 表 `maxL`，`maxR`，分别表示第 `i` 项**左边最大的高度**和**右边最大的高度**。

遍历每一项，每一项 `i` 所能装的水为：
```java
// 每一项所能装的水 = 左右两边比较低的那个高度 - 当前高度
water[i] = Math.min(maxL[i], maxR[i]) - height[i];
```
