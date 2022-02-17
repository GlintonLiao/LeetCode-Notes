# 169. Majority Element

Given an array `nums` of size `n`, return the majority element.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

#### Example 1

```
Input: nums = [3,2,3]
Output: 3
```

#### Example 2

```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

## 解题思路

维护一个出现次数 count ，当 count == 0 时代表当前数字已经被等量的数字抵消了，就换成新的数字，count++

巧妙的地方在于，如果有元素的出现次数是大于 nums.length / 2 的（注意等于是不行的），证明答案的 count 一定不会被清零，这个数字就一定不会被替换掉。
