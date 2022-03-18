# 316. Remove Duplicate Letters

Given a string `s`, remove duplicate letters so that every letter appears once and only once. You must make sure your result is **the smallest in lexicographical order** among all possible results.

#### Example 1:

```
Input: s = "bcabc"
Output: "abc"
```

#### Example 2:

```
Input: s = "cbacdcbc"
Output: "acdb"
``` 

#### Constraints:

+ `1 <= s.length <= 104`
+ `s` consists of lowercase English letters.

## 解题思路

如果一个字母还没有入栈，就把他放进去，同时检测栈中是否有比它大的，而且未来还会再次出现的元素。有就弹出栈，更新对应元素的状态和数量（不在栈中、数量减一）。

如果一个字母已经入栈，就略过。

最后倒序拼合栈中元素，即为答案。
