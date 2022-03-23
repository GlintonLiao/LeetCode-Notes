# 910. Smallest Range II

You are given an integer array `nums` and an integer `k`.

For each index `i` where `0 <= i < nums.length`, change `nums[i]` to be either `nums[i] + k` or `nums[i] - k`.

The *score* of `nums` is the difference between the maximum and minimum elements in `nums`.

Return the minimum **score** of `nums` *after changing the values at each index*.

#### Example 1:

```
Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
```

#### Example 2:

```
Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
```

#### Example 3:

```
Input: nums = [1,3,6], k = 3
Output: 3
Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.
``` 

#### Constraints:

+ `1 <= nums.length <= 10^4`
+ `0 <= nums[i] <= 10^4`
+ `0 <= k <= 10^4`

## 解题思路

首先将数组排序，随后找到一个点，这个点的左侧所有数字加 k，右侧所有数字减 k，答案的右端点应该是左侧的最后一项和右侧最后一项的最大值；左端点应该是右侧第一项和左侧第一项的最小值。

最后更新答案、输出。
