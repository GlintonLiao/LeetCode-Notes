# 118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

![example img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

#### Example 1

```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

#### Example 2

```
Input: numRows = 1
Output: [[1]]
```

## 解题思路

取到上一行的 List，双指针相加即可。

但是这题做得有点傻，用的数组，其实直接 new 一个 List 就行的。虽然最后也是 beats 100% 了。