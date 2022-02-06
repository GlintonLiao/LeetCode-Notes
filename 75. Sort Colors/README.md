# 75. Sort Colors

## 题目描述

Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

#### Example 1

```
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

## 解题思路

题目说了一堆，其实就是数组排序而已......

直接默写快排完事

```java
private void quickSort(int[] nums, int l, int r) {
    if (l >= r) return;
    
    int i = l - 1, j = r + 1, x = nums[l + r >> 1];
    
    while (i < j) {
        do i++; while (nums[i] < x);
        do j--; while (nums[j] > x);
        
        if(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    
    quickSort(nums, l, j);
    quickSort(nums, j + 1, r);
}
```