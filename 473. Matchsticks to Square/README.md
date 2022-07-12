# 473. Matchsticks to Square

You are given an integer array `matchsticks` where `matchsticks[i]` is the length of the `ith` matchstick. You want to use **all the matchsticks** to make one square. You **should not break** any stick, but you can link them up, and each matchstick must be used **exactly one time**.

Return `true` if you can make this square and `false` otherwise.

 

#### Example 1:

```
Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
```

#### Example 2:

```
Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
``` 

#### Constraints:

+ `1 <= matchsticks.length <= 15`
+ `1 <= matchsticks[i] <= 108`

## 解题思路

DFS + 剪枝

剪枝：

1. 如果当前已经能凑齐 3 条边，则一定能凑成 4 条边。

2. 如果此火柴无法凑齐，那和这根火柴相同长度的火柴都可以跳过了

3. 如果此根火柴无法凑齐，且此时一条边为 0，则肯定无法完成匹配

4. 如果此根火柴无法凑齐，且此时长度为正确长度，则肯定无法完成匹配
