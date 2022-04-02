# 680. Valid Palindrome II

Given a string `s`, return true if the `s` can be palindrome after deleting at most **one** character from it.

#### Example 1:

```
Input: s = "aba"
Output: true
```

#### Example 2:

```
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
```

#### Example 3:

```
Input: s = "abc"
Output: false
``` 

#### Constraints:

+ `1 <= s.length <= 10^5`
+ `s` consists of lowercase English letters.

## 解题思路

当遇到第一个不符合条件的位置时，有两种选择，一种是左指针右移，第二种是右指针左移，检测这两种可能，有一个是 true 则为 true。
