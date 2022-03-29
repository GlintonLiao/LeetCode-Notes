# 287. Find the Duplicate Number

Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one repeated number** in nums, return this repeated number.

You must solve the problem **without** modifying the array `nums` and uses only constant extra space.

#### Example 1:

```
Input: nums = [1,3,4,2,2]
Output: 2
```

#### Example 2:

```
Input: nums = [3,1,3,4,2]
Output: 3
``` 

#### Constraints:

+ 1 <= n <= 105
+ nums.length == n + 1
+ 1 <= nums[i] <= n
+ All the integers in nums appear only **once** except for **precisely one integer** which appears two or more times.
 

#### Follow up:

How can we prove that at least one duplicate number must exist in `nums`?

Can you solve the problem in linear runtime complexity?

## 解题思路

最简单的方式是做一个 st[] 数组，遍历时将已经遍历过的数设为 true，遇到 true 就返回当前数。

但如果需要满足 O(1) 的空间复杂度，就可以用二分查找（效率并不如上面那种高）。


