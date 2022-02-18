# 402. Remove K Digits

Given string num representing a non-negative integer `num`, and an integer `k`, return the smallest possible integer after removing `k` digits from `num`.

#### Example 1

```
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
```

#### Example 2

```
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
```

#### Example 3

```
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
```

## 解题思路

若是要结果尽可能小，说明优先去除高位的元素。

我们可以用一个栈去维护（我用了链表，因为涉及到前导 0 和字符拼接）当前的元素，当还可以弹出元素时把大的那个弹出去。最后会得到一个尽可能单调递增的数字。

最后就是要注意边界判断，比如 `k == 0` 或者整个数字是单调递增的（`k` 不会变成 `0`）。
