# 347. Top K Frequent Elements

Given an integer array nums and an integer `k`, return the `k` most frequent elements. You may return the answer in **any order**.

#### Example 1:

```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

#### Example 2:

```
Input: nums = [1], k = 1
Output: [1]
``` 

#### Constraints:

+ `1 <= nums.length <= 10^5`
+ `k` is in the range `[1, the number of unique elements in the array]`.
+ It is **guaranteed** that the answer is **unique**.
 
#### Follow up: 

Your algorithm's time complexity must be better than `O(n log n)`, where `n` is the array's size.

## 解题思路

先排序，然后做一个以出现次数排序的大根堆，然后双指针把所有元素都加进去

最后将大根堆内的前 k 个元素弹出即可。
