# 228. Summary Ranges

You are given a **sorted unique** integer array `nums`.

Return the **smallest sorted** list of ranges that **cover all the numbers in the array exactly**. That is, each element of `nums` is covered by exactly one of the ranges, and there is no integer x such that `x` is in one of the ranges but not in `nums`.

Each range `[a,b]` in the list should be output as:

+ `"a->b"` if `a != b`
+ `"a"` if `a == b`

#### Example 1

```
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
```

#### Example 2

```
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
```

#### Constraints

+ `0 <= nums.length <= 20`
+ `-231 <= nums[i] <= 231 - 1`
+ All the values of `nums` are **unique**.
+ `nums` is sorted in ascending order.

## 解题思路

双指针，对每一个数字进行扩展，然后分情况加进字符串。

值得注意的是，`StringBuilder` 的效率非常高，比直接字符串加减快很多，建议以后都用 `StringBuilder`，操作完就使用 `sb.setLength(0)` 来清零。
