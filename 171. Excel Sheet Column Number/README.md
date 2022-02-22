# 171. Excel Sheet Column Number

Given a string `columnTitle` that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

```
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
```

#### Example 1:

```
Input: columnTitle = "A"
Output: 1
```

#### Example 2:

```
Input: columnTitle = "AB"
Output: 28
```

#### Example 3:

```
Input: columnTitle = "ZY"
Output: 701
```

#### Constraints:

+ `1 <= columnTitle.length <= 7`
+ `columnTitle` consists only of uppercase English letters.
+ `columnTitle` is in the range `["A", "FXSHRXW"]`.

## 解题思路

本题考查进制转换

模板：

```java
int res = 0;

for (T item : List<T>) {
    res *= 进制数;        // 整个数往前推一位
    res += item 对应的值; // 加上个位数的值
}

return res;
```
