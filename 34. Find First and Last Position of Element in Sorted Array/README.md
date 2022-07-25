# 34. Find First and Last Position of Element in Sorted Array

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If target is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

 

#### Example 1:

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

#### Example 2:

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

#### Example 3:

```
Input: nums = [], target = 0
Output: [-1,-1]
``` 

#### Constraints:

+ `0 <= nums.length <= 105`
+ `-109 <= nums[i] <= 109`
+ `nums` is a non-decreasing array.
+ `-109 <= target <= 109`

## 解题思路

做两次二分查找，第一次将区间分为 `[l, mid], [mid + 1, r]`，找到小于等于 `target` 的最大值

第二次将区间分为 `[l, mid - 1], [mid, r]` 查找大于等于 `target` 的最小值。
