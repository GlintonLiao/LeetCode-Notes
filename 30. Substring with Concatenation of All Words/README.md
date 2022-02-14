# 30. Substring with Concatenation of All Words

You are given a string `s` and an array of strings `words` of **the same length**. Return all starting indices of substring(s) in `s` that is a concatenation of each word in `words` **exactly once**, in any order, and **without any intervening characters**.

You can return the answer in any order.

#### Example 1

```
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
```

#### Example 2

```
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
```

#### Example 3

```
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
```

## 解题思路

一开始是 DFS 然后去 match，不出意外 TLE 了。

本题应该使用滑动窗口，题解里面巧妙的地方在于用一个 table 记录了 matching 的状态。

