# 1679. Max Number of K-Sum Pairs

You are given an integer array `nums` and an integer `k`.

In one operation, you can pick two numbers from the array whose sum equals `k` and remove them from the array.

Return the maximum number of operations you can perform on the array.

#### Example 1:

```
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
```

#### Example 2:

```
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
``` 

#### Constraints:

+ `1 <= nums.length <= 105`
+ `1 <= nums[i] <= 109`
+ `1 <= k <= 109`

## 解题思路

一种是做一个 map，检测目标值是否出现过，如果出现就将 map 里的 val 减一，如果没有出现，则将当前值加入 map。

另一种是先排序，然后双指针遍历，如果左右指针之和等于目标值，则左右指针同时移到；若小于目标值，则左指针右移；若大于目标值，则右指针左移。