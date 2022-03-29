# 1461. Check If a String Contains All Binary Codes of Size K

Given a binary string `s` and an integer `k`, return true if every binary code of length `k` is a substring of `s`. Otherwise, return `false`.

#### Example 1:

```
Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
```

#### Example 2:

```
Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
```

#### Example 3:

```
Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.
``` 

#### Constraints:

+ `1 <= s.length <= 5 * 105`
+ `s[i]` is either `'0'` or `'1'`.
+ `1 <= k <= 20`

## 解题思路

这道题只要知道 k 的二进制数组合数是 2^k 就好做了。直接维护一个 set，把每一个长度为 k 的子串都加到 set 里，最后检测 set 的元素数量是不是等于 2^k 即可。
