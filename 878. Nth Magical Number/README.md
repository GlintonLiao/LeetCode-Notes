# 878. Nth Magical Number

A positive integer is *magical* if it is divisible by either `a` or `b`.

Given the three integers `n`, `a`, and `b`, return the nth magical number. Since the answer may be very large, return it modulo `10^9 + 7`.

#### Example 1

```
Input: n = 1, a = 2, b = 3
Output: 2
```

#### Example 2

```
Input: n = 4, a = 2, b = 3
Output: 6
```

#### Constraints

+ `1 <= n <= 109`
+ `2 <= a, b <= 4 * 10^4`

## 解题思路

首先，对于每一个 magical num 来说，可以被 `a` 或 `b` 中的任何一个整除，也可能同时被 `a、b` 整除，那我们如何找到满足这个性质的数的数量呢？

我们可以先找到能被 `a` 整除的数的数量，再找到被 `b` 整除的数的数量，**将两者相加，再减去它们之间重复的部分**（能被 `a` 和 `b` 同时整除的部分），也就是：

> 能被 a 和 b 的**最大公约数**整除的数的数量

求最大公约数（Greatest Common Divisor）有一个模板：

```java
public int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
} 
```

此时，我们就可以进行二分查找了。问题问的是第 `i` 个，也就是查找左边界，所以我们把区间分成 `[l , mid], [mid + 1, r]`。

`check()` 的结果如果大于等于 `n`，说明这个数大了，所以减小它`（r == mid）`，反之 `l = mid + 1`。

最后，因为答案可能很大，所以我们全程都要使用 `long` 来操作。
