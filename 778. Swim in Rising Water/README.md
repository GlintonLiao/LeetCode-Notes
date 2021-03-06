# 778. Swim in Rising Water

You are given an `n x n` integer matrix `grid` where each value `grid[i][j]` represents the elevation at that point `(i, j)`.

The rain starts to fall. At time `t`, the depth of the water everywhere is `t`. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most `t`. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square `(n - 1, n - 1)` if you start at the top left square `(0, 0)`.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2021/06/29/swim1-grid.jpg)

```
Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
```

#### Example 2

![example img](https://assets.leetcode.com/uploads/2021/06/29/swim2-grid-1.jpg)

```
Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
```

#### Constraints

+ `n == grid.length`
+ `n == grid[i].length`
+ `1 <= n <= 50`
+ `0 <= grid[i][j] < n2`
+ Each value `grid[i][j]` is **unique**.

## 解题思路

BFS 连通性模型，需要注意的是出队时才能确定消耗的时间。我一开始是用 st 数组来判定是否走到终点，但因为在扩展过程中 st 表示的是是否入队，所以并不能保证此时的 time 能大于终点的深度，只有终点出队时才能更新在终点的 time。
