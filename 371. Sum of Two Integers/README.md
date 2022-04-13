# 371. Sum of Two Integers

Given two integers `a` and `b`, return the sum of the two integers without using the operators `+` and `-`.

#### Example 1:

```
Input: a = 1, b = 2
Output: 3
```

#### Example 2:

```
Input: a = 2, b = 3
Output: 5
``` 

#### Constraints:

+ `-1000 <= a, b <= 1000`

## 解题思路

按位与可以得到需要进位的那个位置，异或可以得到两个数直接相加但不进位的结果。
