# 611. Valid Triangle Number

Given an integer array `nums`, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

#### Example 1:

```
Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
```

#### Example 2:

```
Input: nums = [4,2,3,4]
Output: 4
``` 

#### Constraints:

+ `1 <= nums.length <= 1000`
+ `0 <= nums[i] <= 1000`

## 解题思路

首先对数组排序，然后从第三个元素开始，遍历三角形的最长的那条边。

对于每条最长边，定义双指针 `l`、`r`，分别指向数组开头和当前元素的前一个元素。

判断，如果当前满足条件，则 `r ~ i` 的所有元素都能满足条件，此时更新最大值，同时让 `r` 变小。

否则，让 `l` 变大。
