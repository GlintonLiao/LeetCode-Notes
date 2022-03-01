# 338. Counting Bits

Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i (0 <= i <= n)`, `ans[i]` is the **number of** `1`'s in the binary representation of `i`.

#### Example 1

```
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
```

#### Example 2

```
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
```

#### Constraints

+ `0 <= n <= 105`

## 解题思路

数位 DP，我们可以发现一个数的二进制数如果右移 `1`，除了最后一位之外，其他位置的 `1` 的数量是不会变的，而最后一位只有两种情况：

1. 偶数，最后一位是 `0`

2. 奇数，最后一位是 `1`

求 `n` 最后一位是否为 `1` ，只需要 `n & 1` 就可以了。这也是比用 `n % 2 == 0` 来判断奇偶更加高效的方法。
