# 668. Kth Smallest Number in Multiplication Table

Nearly everyone has used the Multiplication Table. The multiplication table of size `m x n` is an integer matrix `mat` where `mat[i][j] == i * j` (1-indexed).

Given three integers `m, n`, and `k`, return the `kth` smallest element in the `m x n` multiplication table.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2021/05/02/multtable1-grid.jpg)

```
Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.
```

#### Example 2

![example img](https://assets.leetcode.com/uploads/2021/05/02/multtable2-grid.jpg)

```
Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6.
```

## 解题思路

二分查找，每次查找小于等于 mid 值的数组个数有几个，大于 target 说明找大了，要减小（r = mid），反之增大 l。
