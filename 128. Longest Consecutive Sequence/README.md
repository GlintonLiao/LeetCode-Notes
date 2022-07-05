# 128. Longest Consecutive Sequence

Given an unsorted array of integers `nums`, return *the length of the longest consecutive elements sequence*.

You must write an algorithm that runs in `O(n)` time.

#### Example 1:

```
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

#### Example 2:

```
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
``` 

#### Constraints:

+ `0 <= nums.length <= 105`
+ `-109 <= nums[i] <= 109`

## 解题思路

将所有数字加入 set，对每一个前面没有数字（一个序列的起点）的数字，统计有多少连续数字，迭代取最大值即可。
