# 792. Number of Matching Subsequences

Given a string s and an array of strings `words`, return the number of `words[i]` that is a subsequence of `s`.

A **subsequence** of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

+ For example, `"ace"` is a subsequence of `"abcde"`.
 

#### Example 1:

```
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
```

#### Example 2:

```
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
``` 

#### Constraints:

+ `1 <= s.length <= 5 * 104`
+ `1 <= words.length <= 5000`
+ `1 <= words[i].length <= 50`
+ `s` and `words[i]` consist of only lowercase English letters.

## 解题思路

做一个大小为 26 的桶，按照单词的首字母将其放入桶中。

遍历模式串，找到当前字母对应的桶，对桶内的每一个字符串，去掉它的首字母，再放入对应的桶中。

如果一个串的长度已经是 1，去掉一个就是 0 了，说明遍历完成，res++
