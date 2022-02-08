# 258. Add Digits

Given an integer `num`, repeatedly add all its digits until the result has only one digit, and return it.

#### Example 1

```
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
```

#### Example 2 

```
Input: num = 0
Output: 0
```

#### Constraints

- `0 <= num <= 231 - 1`

## 解题思路

LeetCode 讨论区全是奇技淫巧的公式解法，其实没必要，正常做就行。取数的最后一位累加，递归处理即可。

[LeetCode Discussion](https://leetcode.com/problems/add-digits/discuss/?currentPage=1&orderBy=most_votes&query=)
