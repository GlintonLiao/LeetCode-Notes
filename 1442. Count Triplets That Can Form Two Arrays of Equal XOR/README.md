# 1442. Count Triplets That Can Form Two Arrays of Equal XOR

Given an array of integers `arr`.

We want to select three indices `i`, `j` and `k` where `(0 <= i < j <= k < arr.length)`.

Let's define `a` and `b` as follows:

`a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]`
`b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]`
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (`i`, `j` and `k`) Where `a == b`.

#### Example 1:

```
Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
```

#### Example 2:

```
Input: arr = [1,1,1,1,1]
Output: 10
``` 

#### Constraints:

+ `1 <= arr.length <= 300`
+ `1 <= arr[i] <= 10^8`

## 解题思路

`a == b` 可以转化为 `a ^ b == 0`，所以从 `i` 到 `j` 异或为 0，就合法，`k` 是什么不重要。
