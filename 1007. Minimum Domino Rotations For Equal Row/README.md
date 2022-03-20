# 1007. Minimum Domino Rotations For Equal Row

In a row of dominoes, `tops[i]` and `bottoms[i]` represent the top and bottom halves of the `ith` domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the `ith` domino, so that `tops[i]` and `bottoms[i]` swap values.

Return the minimum number of rotations so that all the values in `tops` are the same, or all the values in `bottoms` are the same.

If it cannot be done, return `-1`.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2021/05/14/domino.png)

```
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
```

#### Example 2:

```
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
``` 

#### Constraints:

+ `2 <= tops.length <= 2 * 104`
+ `bottoms.length == tops.length`
+ `1 <= tops[i], bottoms[i] <= 6`

## 解题思路

首先，我们检测 tops 的前两项和 bottoms 的前两项有没有重复的数，会有 3 种情况：

1. 只有一个数重复，则我们把这个数作为目标的数，检测需要反转多少次。

2. 两个数重复，则对这两个数都进行一次检测，返回更大的那个（如果有一个是 -1 的话）。

3. 没有数重复，则无解，不用遍历直接返回 -1。

对于检测，只要在某一次目标值均不在 tops 和 bottoms，则无解直接返回 -1；同时我们需要记录一下 tops 和 bottoms 的值都等于目标值的数量，最后输出的时候要减掉这一部分。
