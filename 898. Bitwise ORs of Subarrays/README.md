# 898. Bitwise ORs of Subarrays

We have an array `arr` of non-negative integers.

For every (contiguous) subarray `sub = [arr[i], arr[i + 1], ..., arr[j]]` (with `i <= j`), we take the bitwise OR of all the elements in sub, obtaining a result `arr[i] | arr[i + 1] | ... | arr[j]`.

Return the number of possible results. Results that occur more than once are only counted once in the final answer

#### Example 1:

```
Input: arr = [0]
Output: 1
Explanation: There is only one possible result: 0.
```

#### Example 2:

```
Input: arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.
```

#### Example 3:

```
Input: arr = [1,2,4]
Output: 6
Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
``` 

#### Constraints:

+ `1 <= nums.length <= 5 * 10^4`
+ 0 <= nums[i] <= 10^9

## 解题思路

这道题有一个很有用的知识点，就是怎么遍历连续一段元素所有的子串组合。

我们可以维护一个 `prev` 和 `curr`，每一次遍历把当前元素加进 `curr`，然后从 `prev` 里面取出所有元素加上当前元素，组成一个新的组之后，加进 `curr`。

最后 `curr` 变成下一次遍历的 `prev`。
