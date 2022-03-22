# 1663. Smallest String With A Given Numeric Value

The **numeric value** of a **lowercase character** is defined as its position `(1-indexed)` in the alphabet, so the numeric value of `a` is `1`, the numeric value of `b` is `2`, the numeric value of `c` is `3`, and so on.

The **numeric value** of a `string` consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string `"abe"` is equal to `1 + 2 + 5 = 8`.

You are given two integers `n` and `k`. Return the **lexicographically smallest string** with length equal to `n` and numeric value equal to `k`.

Note that a string `x` is lexicographically smaller than string `y` if `x` comes before `y` in dictionary order, that is, either `x` is a prefix of `y`, or if `i` is the first position such that `x[i] != y[i]`, then `x[i]` comes before `y[i]` in alphabetic order.

#### Example 1:

```
Input: n = 3, k = 27
Output: "aay"
Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
```

#### Example 2:

```
Input: n = 5, k = 73
Output: "aaszz"
``` 

#### Constraints:

+ `1 <= n <= 105`
+ `n <= k <= 26 * n`

## 解题思路

我们可以把这道题转换成一个由 `a` 构成，长度为 `n` 的字符串，从后往前加数，一直加到 `k == 0` 为止的流程。

所以，当我们构造完初始字符串之后，`k` 应该减去 `n`，因为每一位都填入了一个 `1`。

随后，当遍历字符串的时候，我们就对比 `25` 和当前 `k` 的大小，如果 `k > 25`，则我们需要给当前的字母加上 `25`，字母 `'a'` 就会变成字母 `'z'`，随后让 `k` 减去当前加在字母上的数值即可。

除此之外，还有另一种思路。

我们首先构造一个空串，从后往前遍历的时候，
