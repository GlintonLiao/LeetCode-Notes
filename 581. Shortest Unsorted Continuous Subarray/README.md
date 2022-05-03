# 581. Shortest Unsorted Continuous Subarray

Given an integer array `nums`, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

#### Example 1:

```
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
```

#### Example 2:

```
Input: nums = [1,2,3,4]
Output: 0
```

#### Example 3:

```
Input: nums = [1]
Output: 0
``` 

#### Constraints:

+ `1 <= nums.length <= 10^4`
+ `-10^5 <= nums[i] <= 10^5`

## 解题思路

我们可以把整个数组分成左中右 3 个部分，左边和右边是单调递增的，则中间的部分需要满足：

1. 最大值小于右边部分的最小值（左端点）
2. 最小值大于左边部分的最大值（右端点）

所以，我们可以分别找出两个交界处，就是答案。