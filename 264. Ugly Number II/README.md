# 264. Ugly Number II

An **ugly number** is a positive integer whose prime factors are limited to `2`, `3`, and `5`.

Given an integer `n`, return the nth ugly number.

#### Example 1:

```
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
```

#### Example 2:

```
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
``` 

#### Constraints:

+ `1 <= n <= 1690`

## 解题思路

有两种思路，一种是使用 PriorityQueue 或者 TreeSet，渐进地计算所有符合要求的数；或者用多指针的思想，逐步填入最小值的同时避免重复值。
