# 1542. Find Longest Awesome Substring

You are given a string `s`. An awesome substring is a non-empty substring of `s` such that we can make any number of swaps in order to make it a palindrome.

Return the length of the maximum length **awesome substring** of `s`.

#### Example 1:

```
Input: s = "3242415"
Output: 5
Explanation: "24241" is the longest awesome substring, we can form the palindrome "24142" with some swaps.
```

#### Example 2:

```
Input: s = "12345678"
Output: 1
```

#### Example 3:

```
Input: s = "213123"
Output: 6
Explanation: "213123" is the longest awesome substring, we can form the palindrome "231132" with some swaps.
``` 

#### Constraints:

+ `1 <= s.length <= 10^5`
+ `s` consists only of digits.

## 解题思路

满足超赞字符串的条件：

再一次遇到之前已经出现过的 status ，说明所有数字都出现了偶数次。（因为每一位二进制位的奇偶性都相同的话，不论都是 1 还是 0，奇-奇=偶-偶=偶，都代表这些字符在中间这一段出现了偶数次，该超赞字符串的长度为 当前位置 i - 最早出现的位置 pre[status]当前位置i−最早出现的位置pre[status]）

与之前出现过的 status 只有一个二进制位不同，说明这个不同的二进制位出现了奇数次 (奇−偶=偶−奇=奇)，其余的二进制位出现了偶数次，仍然满足回文字符串的条件。针对这种情况，我们只需要从 0-9 枚举二进制位，然后看之前是否出现过即可，同时维护答案。
