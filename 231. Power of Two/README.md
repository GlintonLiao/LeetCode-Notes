# 231. Power of Two

Given an integer `n`, return `true` if *it is a power of two*. Otherwise, return `false`.

An integer `n` is a power of two, if there exists an integer `x` such that `n == 2x`.

#### Example 1:

```
Input: n = 1
Output: true
Explanation: 20 = 1
```

#### Example 2:

```
Input: n = 16
Output: true
Explanation: 24 = 16
```

#### Example 3:

```
Input: n = 3
Output: false
``` 

#### Constraints:

+ `-2^31 <= n <= 2^31 - 1`
 

#### Follow up: 

Could you solve it without loops/recursion?

## 解题思路

二的多少次方，都符合「整个数只有一个 `1`」这个规则。

方法一：当最后一位是 `0` 时，右移一位，直到不能移动时，检测此时是否为 `1`。

方法二：`n & (n - 1)` 可以把数的最后一位 `1` 变成 `0`，所以检测经过这个操作之后是否为 0。
