# 41. First Missing Positive

Given an unsorted integer array `nums`, return the smallest missing positive integer.

You must implement an algorithm that runs in `O(n)` time and uses constant extra space.

#### Example 1

```
Input: nums = [1,2,0]
Output: 3
```

#### Example 2

```
Input: nums = [3,4,-1,1]
Output: 2
```

#### Example 3

```
Input: nums = [7,8,9,11,12]
Output: 1
```

## 解题思路

凡是要求 `O(n)` 时间复杂度和 `O(1)` 空间复杂度的 array 题，都是把原数组当成新数组，把符合条件的值填入对应的位置。

对于这道题来说，我们只需要把符合「数值比 1 大，比数组长度小」的值放入「数值 - 1」的下标处就行，最后遍历整个数组，找到第一个数值不对的下标，输出下标 + 1 即可。

```java
while (i < nums.length) {
  // 只要数满足范围，且对应位置还没有正确的数，就换（因为同一个 i 可能要换好几次）
  if (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
    swap(nums, i, nums[i] - 1);
  } else {
    i += 1;
  }
}
```