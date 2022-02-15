# 137. Single Number II

Given an integer array `nums` where every element appears **three times** except for one, which appears **exactly once**. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

#### Example 1

```
Input: nums = [2,2,3,2]
Output: 3
```

#### Example 2

```
Input: nums = [0,1,0,1,0,1,99]
Output: 99
```

## 解题思路

### 前置知识

1. n & 1 == 1，n & 0 == 0
2. n ^ n == 0, n ^ 0 == n
3. ~1 == 0, ~0 == 1

```java
// 将 nums[i] 加入 ones，当且仅当 twos 中没有 nums[i] 且 ones 中没有 nums[i]，当 num[i] 出现第 2 此，ones 会清零
ones = (ones ^ nums[i]) & ~twos;
// 将 nums[i] 加入 twos，当且仅当 ones 中有 nums[i]，当 nums[i] 出现第三遍，twos 会清零
twos = (twos ^ nums[i]) & ~ones;
```

