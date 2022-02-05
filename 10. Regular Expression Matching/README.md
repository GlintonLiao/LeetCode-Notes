# 10. Regular Expression Matching

## 题目描述

Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'` where:

* `'.'` Matches any single character.​​​​
* `'*'` Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

#### Example 1

```
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

#### Example 2

```
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
```

#### Example 3

```
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```

#### Constraints

* `1 <= s.length <= 20`
* `1 <= p.length <= 30`
* `s` contains only lowercase English letters.
* `p` contains only lowercase English letters, `'.'`, and `'*'`.
* It is guaranteed for each appearance of the character `'*'`, there will be a previous valid character to match.

## 解题思路

一开始读错题了，以为 `*` 可以 match 它之前的所有字符，搞得特别复杂，但其实 `*` 只能 match 前一个字符，并且是否  match 是可选的。也就是说 `*` 和之前的一个字符可以一起当成一个空串。

### 状态表示

**集合表示**

`f[i, j]` 表示 `s` 的前 `i` 个字母和 `p` 的前 `j` 个字母匹配方法的集合。

**集合属性**

布尔值，只要集合中有一项是 `true`，则整个集合都是 `true`。

### 状态计算

#### 初始化

`f[0][0]` 表示空串之间匹配，为 `true`。

遍历 `p` 的每一个字符，如果 `f[0][j - 2]` 是 `true`（可以当成空串），则 `f[0][j]` 为 `true`。

#### 主循环

对于每一个集合，有两种互斥的情况：

1. 第 `j` 个字母不是 `*`
2. 第 `j` 个字母是 `*`

对于第一种情况，如果 `s` 的第 `i` 个字符与 `p` 的第 `j` 个字符匹配，或者 `p` 的第 `j` 个字母是 `.` 通配符，则可以相互去掉最后一个字符：
```java
f[i][j] = f[i - 1][j - 1];
```
<br/>

对于第二种情况，就有两种选择了：

1. 把 `*` 和前一个字符当成空串
2. 把 `*` 和前一个字符与 `s` 匹配（如果可以匹配的话）

这两种选择，只要有一种选择是 `true`，整个就是 `true`。

```java
if (不符合匹配规则) {
  f[i][j] = f[i][j - 2];
} else {
  f[i][j] = f[i][j - 2] || f[i - 1][j];
}
```

#### 最后

按照以上的思路，在遍历 `i, j` 的时候其实先 `j` 后 `i` 会更合理一点，虽然其实两种都可以。