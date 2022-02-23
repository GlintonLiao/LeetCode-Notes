# 378. Kth Smallest Element in a Sorted Matrix

Given an `n x n matrix` where each of the rows and columns is sorted in ascending order, return the `kth` smallest element in the matrix.

Note that it is the `kth` smallest element **in the sorted order**, not the `kth` **distinct** element.

You must find a solution with a memory complexity better than `O(n2)`.

 

#### Example 1:

```
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
```

#### Example 2:

```
Input: matrix = [[-5]], k = 1
Output: -5
``` 

#### Constraints:

+ `n == matrix.length == matrix[i].length`
+ `1 <= n <= 300`
+ `-109 <= matrix[i][j] <= 109`
+ All the rows and columns of matrix are **guaranteed** to be sorted in **non-decreasing order**.
+ `1 <= k <= n2`

## 解题思路

第一次做空间的二分查找，还是比较难的。

最难的地方在于统计 `mid` 左边和右边的元素个数。本题采用的是从左下角向右上角扫描，如果当前元素 < `mid`，表示这一整列都 < `mid`， 所以加上 `i + 1`，`j++`；反之向上移动 `i`。
