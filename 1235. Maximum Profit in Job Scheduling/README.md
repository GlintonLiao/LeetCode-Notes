# 1235. Maximum Profit in Job Scheduling

We have `n` jobs, where every job is scheduled to be done from `startTime[i]` to `endTime[i]`, obtaining a profit of `profit[i]`.

You're given the `startTime`, `endTime` and `profit` arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time `X` you will be able to start another job that starts at time `X`.

 

#### Example 1:

![example img](https://assets.leetcode.com/uploads/2019/10/10/sample1_1584.png)

```
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
```

#### Example 2:

![example img](https://assets.leetcode.com/uploads/2019/10/10/sample22_1584.png)

```
Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
```

#### Example 3:

![example img](https://assets.leetcode.com/uploads/2019/10/10/sample3_1584.png)

```
Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
```

#### Constraints:

+ `1 <= startTime.length == endTime.length == profit.length <= 5 * 104`
+ `1 <= startTime[i] < endTime[i] <= 109`
+ `1 <= profit[i] <= 104`

## 解题思路

动态规划 + 二分查找。

`f[i]` 表示在时间为 `i` 时，所有的选择方案（的 `profit` 最大值）。

所以我们应该对 `endTime` 排序，`i` 就表示一个区间。`f[i]` 就是这个区间的选择方案。

则 `f[i]` 可以分成两种情况：

1. 不包含第 `i` 项的方案，即 `f[i - 1]`

2. 包含第 `i` 项的方案，等于上一个合法方案 `f[j]` + 当前这一项的 `profit[i]`

两者取 `max` 就是 `f[i]` 的值。

```java
// 状态转移方程
f[i] = Math.max(f[i - 1], f[j] + profit[i]);
```

这道题其实最难的是怎么找到上一个集合 `f[j]` 的值

我们可以对前 `i` 项进行二分查找。第 `j` 项的 `endTime` 不能大于第 `i` 项的 `startTime`，找到满足这个条件的最大的 `endTime`，也就是 `j` 的值。

需要注意的是，二分查找一定有解，但原问题不一定有解，我们需要判断一下找到的第 `j` 项是否满足条件。
