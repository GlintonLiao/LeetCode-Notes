# 1288. Remove Covered Intervals

Given an array `intervals` where `intervals[i] = [li, ri]` represent the interval `[li, ri)`, remove all intervals that are covered by another interval in the list.

The interval `[a, b)` is covered by the interval `[c, d)` if and only if `c <= a` and `b <= d`.

Return the number of remaining intervals.

#### Example 1

```
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
```

#### Example 2

```
Input: intervals = [[1,4],[2,3]]
Output: 1
```

## 解题思路

简单区间问题，按左端点排序之后枚举，不同规则不同处理。

维护一个 count，包含就减 1。
