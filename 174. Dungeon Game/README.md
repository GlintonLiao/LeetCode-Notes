# 174. Dungeon Game

The demons had captured the princess and imprisoned her in **the bottom-right** corner of a `dungeon`. The `dungeon` consists of `m x n` rooms laid out in a 2D grid. Our valiant knight was initially positioned in **the top-left room** and must fight his way through `dungeon` to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to `0` or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only **rightward** or **downward** in each step.

Return the *knight's minimum initial health* so that he can rescue the princess.

**Note** that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.



#### Example 1:

![example img](https://assets.leetcode.com/uploads/2021/03/13/dungeon-grid-1.jpg)

```
Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
```

#### Example 2:

```
Input: dungeon = [[0]]
Output: 1
``` 

#### Constraints:

+ `m == dungeon.length`
+ `n == dungeon[i].length`
+ `1 <= m, n <= 200`
+ `-1000 <= dungeon[i][j] <= 1000`

## 解题思路

这题一开始以为是一个经典三角形模型，但后来发现不对，经典三角形模型只能求解整条路径最终的最大值或最小值，但题目问的是每一条路径中最低点的最大值。

### 状态表示

#### 集合表示

一开始的想法：f[i][j] 表示以 [i, j] 结尾的所有路径集合。

正确的想法：f[i][j] 表示以 [i, j] 出发走到终点的所有路径集合。

#### 集合属性

最小值 min

### 状态计算

如果正着遍历，是得不到答案的，会发现我们并不能保证此时的血量能够走到终点，还需要靠近终点那一侧的信息，所以我们应该倒着遍历，f[0][0] 即为答案。

首先需要初始化最后一排和最后一列，初始化的规则是：

```java
当前状态 = Math.max(前一项状态 - 当前值, 1);
```

如果说减完之后为负数，说明这一格是加血的，直接砍到 1 就行。

最后遍历矩阵，每一格有两条路可以来，取这两条路的较小值即可。
