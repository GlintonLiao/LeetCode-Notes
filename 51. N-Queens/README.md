# 51. N-Queens

The **n-queens** puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return all distinct **solutions to the n-queens puzzle**. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2020/11/13/queens.jpg)

```
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
```

```
Input: n = 1
Output: [["Q"]]
```

## 解题思路

DFS 即可。但是我一开始写的是遍历 `i` 和 `j`，侥幸以 2500ms AC 了一次，再点提交就 TLE 了。

正确的做法应该是递归维护目前的 `i`，只遍历 `j`，因为只要有一行选了，就不可能再选这一行；除了去重之外也可以用这个 `i` 判断是否结束 DFS。

优化掉一个维度之后，直接从 2500ms 变成了 3ms。