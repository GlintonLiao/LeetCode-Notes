# 392. Is Subsequence

Given two strings `s` and `t`, return `true` if s is `a` subsequence of `t`, or `false` otherwise.

A **subsequence** of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not).

#### Example 1

```
Input: s = "abc", t = "ahbgdc"
Output: true
```

#### Example 2

```
Input: s = "axc", t = "ahbgdc"
Output: false
```

#### Constraints

+ `0 <= s.length <= 100`
+ `0 <= t.length <= 104`
+ `s` and `t` consist only of lowercase English letters.

## 解题思路

做一个队列把模式串入队，遍历原始串，匹配就弹出元素。

最后检测队列是否为空。

这题用双指针也可以做，代码量还少一点，空间复杂度也低，Solution2 就是双指针解法。
