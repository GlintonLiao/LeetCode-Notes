# 32. Longest Valid Parentheses

Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

#### Example 1

```
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
```

#### Example 2

```
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
```

#### Example 3

```
Input: s = ""
Output: 0
```

#### Constrains:

* `0 <= s.length <= 3 * 10^4`
* `s[i]` is `'('`, or `')'`.

## 解题思路

首先，合法括号对的原则是：

1. 最后，左括号数量等于右括号数量
2. 过程中不能出现右括号数量大于左括号数量

如果题目中没有通配符，则可以利用栈来解决。因为这道题关于字符串长度的（也就是距离），我们可以用栈来维护左括号的下标。

### 状态表示

#### 集合表示

`f[i]` 表示所有以第 `i` 个字符结尾的合法括号对选法。

#### 集合属性

最大长度

### 状态计算

第 `i` 个字符有两种情况：

1. 左括号，不合法（不可能以 `'('` 结尾）

```java
f[i] = 0
```

2. 右括号

    2.1 右括号数量大于左括号数量（栈为空）：

    ```java
    f[i] = 0;
    ```
    2.2 右括号数量小于等于左括号数量：

    ```java
    // 找到与之匹配的左括号
    int l = stack.pop();
    // 最大距离为：当前括号对距离 + 前面的最大距离
    f[i] =  r - l + 1 + f[l - 1];
    ``` 

最后，输出 f 里面的最大值即可。

