# 1095. Find in Mountain Array

(This problem is an **interactive problem**.)

You may recall that an array `arr` is a mountain array if and only if:

+ arr.length >= 3
+ There exists some i with 0 < i < arr.length - 1 such that:
  + arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
  + arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Given a mountain array `mountainArr`, return the **minimum** `index` such that `mountainArr.get(index) == target`. If such an `index` does not exist, return `-1`.

**You cannot access the mountain array directly**. You may only access the array using a `MountainArray` interface:

+ `MountainArray.get(k)` returns the element of the array at index `k` (0-indexed).
+ `MountainArray.length()` returns the length of the array.

Submissions making more than `100` calls to `MountainArray.get` will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

#### Example 1:

```
Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
```

#### Example 2:

```
Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
``` 

#### Constraints:

+ `3 <= mountain_arr.length() <= 104`
+ `0 <= target <= 109`
+ `0 <= mountain_arr.get(index) <= 109`

## 解题思路

做两次二分查找，第一次查找 `peek` 在哪里。

然后我们可以把 `arr` 分成左右两个单调的 `subArr`，`peek` 左边是单调递增的，右边是单调递减的。然后就可以对这两个 `arr` 进行第二次二分查找了。

我们先找左边有没有这个数，因为如果两边都有，我们会返回左边的那一个。

如果左边找不到，再去找右边有没有。

如果两边都没有，就返回 `-1`。
