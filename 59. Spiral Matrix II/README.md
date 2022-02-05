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
// 用四条边作为边界，一边填数一边更新边界
public static int[][] generateMatrix(int n) {
	int[][] matrix = new int[n][n];
	int left = 0,top = 0;
	int right = n - 1,down = n - 1;
	int num = 1;

	while (left <= right) {
		for (int j = left; j <= right; j ++) {
			matrix[top][j] = num ++;
		}
		top ++;

		for (int i = top; i <= down; i ++) {
			matrix[i][right] = num ++;
		}
		right --;

		for (int j = right; j >= left; j --) {
			matrix[down][j] = num ++;
		}
		down --;

		for (int i = down; i >= top; i --) {
			matrix[i][left] = num ++;
		}
		left ++;
	}

	return matrix;
}
```
