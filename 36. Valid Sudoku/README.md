# 36. Valid Sudoku

## 题目描述

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

#### Note

* A Sudoku board (partially filled) could be valid but is not necessarily solvable.
* Only the filled cells need to be validated according to the mentioned rules.

#### Example 1

![alt sample pic](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

```
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
```

## 解题思路

### 思考

在面对形如「某些条件下不能出现重复元素」的题目，我们都可以使用 `HashSet` 这样的数据结构。

可以使用 `HashSet` 中的 `add(E e)` 方法，加入一句 `当前条件 + 值` 的字符串。

同时，这个方法会返回一个布尔值，所以可以在添加值的时候顺便判断是否能够添加值。

```
HashSet<String> seen = new HashSet<>();
if (!seen.add("xx条件下 " + val)) return false;
```
### 扩展

[HashSet Api Reference](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html)