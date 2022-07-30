# 916. Word Subsets

You are given two string arrays `words1` and `words2`.

A string `b` is a **subset** of string `a` if every letter in `b` occurs in a including multiplicity.

For example, `"wrr"` is a subset of `"warrior"` but is not a subset of `"world"`.
A string `a` from `words1` is **universal** if for every string `b` in `words2`, `b` is a subset of `a`.

Return an array of all the **universal** strings in `words1`. You may return the answer in any order.
 
### Example 1:

```
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
```

#### Example 2:

```
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
``` 

#### Constraints:

+ `1 <= words1.length, words2.length <= 104`
+ `1 <= words1[i].length, words2[i].length <= 10`
+ `words1[i]` and `words2[i]` consist only of lowercase English letters.
+ All the strings of `words1` are unique.

## 解题思路

题意：对于 `words1` 中的一个字符串，`word2` 里面的所有字符串都要包含在这个字符串之内。

也就是说，对于 `words1` 的每个字符串，字母的出现次数要大于 `words2` 中所有字符串里，同一个字母出现次数的最大值。

所以我们先统计 `words2` 中的每个字符串，记录字母出现的最大值，随后检测 `words1`，如果发现 `words2` 中字母的最大值大于当前字符串字母出现次数，说明不满足条件。
