# 59. Spiral Matrix II

## 题目描述

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

#### Exampel 1

![example img](https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg)

```
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
```

## 解题思路

没什么好说的，背就完了。

```java
// 螺旋遍历矩阵模版
int leftBound = 0, upperBound = 0, rightBound = n - 1, lowerBound = n - 1;
int num = 1;
    
while (num <= n * n) {
    // left to right
    if (upperBound <= lowerBound) {
        for (int j = leftBound; j <= rightBound; j++) {
            matrix[upperBound][j] = num++;
        }
        upperBound++;
    }
    
    // top to bottom
    if (leftBound <= rightBound) {
        for (int i = upperBound; i <= lowerBound; i++) {
            matrix[i][rightBound] = num++;
        }
        rightBound--;
    }
    
    // right to left
    if (upperBound <= lowerBound) {
        for (int j = rightBound; j >= leftBound; j--) {
            matrix[lowerBound][j] = num++;
        }
        lowerBound--;
    }
    
    // bottom to top
    if (leftBound <= rightBound) {
        for (int i = lowerBound; i >= upperBound; i--) {
            matrix[i][leftBound] = num++;
        }
        leftBound++;
    }
    
  }
```
