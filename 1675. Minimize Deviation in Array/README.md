# 1675. Minimize Deviation in Array

You are given an array `nums` of `n` positive integers.

You can perform two types of operations on any element of the array any number of times:

+ If the element is **even**, **divide** it by `2`.

  + For example, if the array is `[1,2,3,4]`, then you can do this operation on the last element, and the array will be `[1,2,3,2]`.

+ If the element is **odd**, **multiply** it by `2`.

  + For example, if the array is `[1,2,3,4]`, then you can do this operation on the first element, and the array will be `[2,2,3,4]`.

The **deviation** of the array is the **maximum difference** between any two elements in the array.

Return the **minimum deviation** the array can have after performing some number of operations.

#### Example 1

```
Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
```

#### Example 2

```
Input: nums = [4,1,5,20,3]
Output: 3
Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
```

#### Example 3

```
Input: nums = [2,10,8]
Output: 3
```

## 解题思路

首先，如果是奇数，只能 * 2 一次变成偶数。

我们可以做一个堆，把所有数字都变得尽量大，然后往放进堆。

每次取出堆内最小的数和最大的数，做一个减法得到当前的 deviation，并且 update 答案。

对于每个数来说，如果它还能变小（是偶数），就把它变小放进堆。如果不能变小（是奇数），则表明我们找到了边界（不会再出现更优的解了，但当前解不一定是最优解，答案才是最优解），就返回答案。
