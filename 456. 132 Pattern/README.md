# 456. 132 Pattern

Given an array of `n` integers `nums`, a **132 pattern** is a subsequence of three integers `nums[i]`, `nums[j]` and `nums[k]` such that `i < j < k` and `nums[i] < nums[k] < nums[j]`.

Return `true` if there is a 132 pattern in `nums`, otherwise, return `false`.

#### Example 1:

```
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
```

#### Example 2:

```
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
```

#### Example 3:

```
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
``` 

#### Constraints:

+ `n == nums.length`
+ `1 <= n <= 2 * 10^5`
+ `-10^9 <= nums[i] <= 10^9`

## 解题思路

遍历 1，单调栈维护 2，k 维护 3

Traverse from the end, when the current element is greater than the top element in the stack

we found a possible two, which meets the "3 - 2" pattern.

pop all the possible twos out, and push the current element into the stack.

so, the elements popped out are twos, the elements in the stack are threes.

now, we only need an element which is smaller than the max value in the twos, and we will meet the "1 - 3 - 2" pattern.