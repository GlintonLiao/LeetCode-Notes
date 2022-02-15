# 44. Wildcard Matching

Given an input string (`s`) and a pattern (`p`), implement wildcard pattern matching with support for `'?'` and `'*'` where:

+ `'?'` Matches any single character.

+ `'*'` Matches any sequence of characters (including the empty sequence).

The matching should cover the **entire** input string (not partial).

#### Example 1

```
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

#### Example 2

```
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
```

#### Example 3

```
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```

## 解题思路

这题可以说是和 Regular Expression Matching 那题如出一撤，只不过通配符 * 从 match 前一个字符变成 match 任意数量字符。

### 状态表示

#### 集合表示

`f[i][j]` 表示 s 的前 i 个字符和 p 的前 j 个字符匹配的方案。

#### 集合属性

布尔值，集合中有一种为 true 整体为 true

### 状态计算

首先初始化 `f[0][0]` 为 true，表示空串和空串之间匹配。

最后一个字符 `charAt(j)` 有两种情况：

1. 不是通配符 *

```java
if (可以匹配) {
    f[i][j] = f[i - 1][j - 1];
}
```

2. 是通配符 *

```java
// 把 * 当成空串
f[i][j] = f[i][j - 1];
// 把 * 当成全部，加 s[i] 和不加的结果应该是一样的
// 这个会把 f[][] 中 * 的那一列全部变成同一个值
f[i][j] = f[i - 1][j]
```

状态转移方程为：

```java
if (最后一位不是 *) {
    if (可以匹配) {
      f[i][j] = f[i - 1][j - 1];
    }
} else {
  f[i][j] = f[i - 1][j] || f[i][j - 1];
}
```