# 136. Single Number

Given a **non-empty** array of integers `nums`, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

#### Example 1

```
Input: nums = [2,2,1]
Output: 1
```

#### Example 2

```
Input: nums = [4,1,2,1,2]
Output: 4
```

#### Example 3

```
Input: nums = [1]
Output: 1
```

## 解题思路

本题考查位运算的技巧。

1. n ^ n == 0;
2. n ^ 0 == n;

所以对于每一项都进行异或操作，同数值的都化成 0 了，最后得到的就是多出来的那个数。