# 1139. Largest 1-Bordered Square

Given a 2D `grid` of `0s` and `1s`, return the number of elements in the largest **square** subgrid that has all 1s on its border, or `0` if such a subgrid doesn't exist in the grid.

#### Example 1:

```
Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 9
```

#### Example 2:

```
Input: grid = [[1,1,0,0]]
Output: 1
``` 

#### Constraints:

+ `1 <= grid.length <= 100`
+ `1 <= grid[0].length <= 100`
+ `grid[i][j]` is `0` or `1`

## 解题思路

做两个矩阵，分别记录每一行和每一列的 1 的数量的前缀和（遇到不满足条件的要归零）。

随后从大到小遍历方形长度，再遍历这个长度下每一个 x、y，如果四条边都满足条件，就是答案。
