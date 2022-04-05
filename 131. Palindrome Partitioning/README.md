# 131. Palindrome Partitioning

Given a string `s`, partition `s` such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of `s`.

A palindrome string is a string that reads the same backward as forward.

#### Example 1:

```
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

#### Example 2:

```
Input: s = "a"
Output: [["a"]]
``` 

#### Constraints:

+ `1 <= s.length <= 16`
+ `s` contains only lowercase English letters.

## 解题思路

简单 dfs 所有的子串，利用右指针跳到下一个子串的起点继续 dfs 即可。