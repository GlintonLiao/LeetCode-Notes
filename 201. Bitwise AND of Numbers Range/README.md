# 201. Bitwise AND of Numbers Range

Given two integers `left` and `right` that represent the range `[left, right]`, return the *bitwise AND* of all numbers in this range, inclusive.

#### Example 1:

```
Input: left = 5, right = 7
Output: 4
```

#### Example 2:

```
Input: left = 0, right = 0
Output: 0
```

#### Example 3:

```
Input: left = 1, right = 2147483647
Output: 0
``` 

#### Constraints:

+ `0 <= left <= right <= 2^31 - 1`

## 解题思路

实际上，连续的几个数之间做按位与的话，会是这样的：

```
0001100
0001101
0001110
0001111

ans:
0001100
```

所以，最后的结果应该是 `left` 和 `right` 相等的部分，即前 5 位。
