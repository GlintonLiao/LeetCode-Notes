# 856. Score of Parentheses

Given a balanced parentheses string `s`, return the **score** of the string.

The **score** of a balanced parentheses string is based on the following rule:

+ `"()"` has score `1`.
+ `AB` has score `A + B`, where `A` and `B` are balanced parentheses strings.
+ (`A)` has score `2 * A`, where `A` is a balanced parentheses string.
 
#### Example 1:

```
Input: s = "()"
Output: 1
```

#### Example 2:

```
Input: s = "(())"
Output: 2
```

#### Example 3:

```
Input: s = "()()"
Output: 2
``` 

#### Constraints:

+ `2 <= s.length <= 50`
+ `s` consists of only `'('` and `')'`.
+ `s` is a balanced parentheses string.

## 解题思路

我们可以维护一个栈，当进入下一层时（遇到左括号时），我们将当前的 `count` 存入栈中，同时让 `count` 归零。

当我们遇到右括号时，更新的 `count` 应该等于这一层的 `count`，即 `count * 2`，再加上上一层的 `count`，即栈中数字。
