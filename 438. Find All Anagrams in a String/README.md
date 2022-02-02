# 438. Find All Anagrams in a String

## 题目描述

Given two strings `s` and `p`, return an array of all the start indices of `p's` anagrams in `s`. You may return the answer in **any order.**

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

#### Example

```
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
```

#### Constraints:
* `1 <= s.length, p.length <= 3 * 104`
* `s` and `p` consist of lowercase English letters.

## 解题思路

### 思考

字符串匹配问题，首先需要想到**滑动窗口**。

### 滑动窗口

1. 制作一个 `HashMap`，将模版字符串 `p` 的每个字符放入 `map`。

```java
Map<Character, Integer> map = new HashMap<>();
for (char c : p.toCharArray()) {
    map.put(c, map.getOrDefault(c, 0) + 1);
}
```
2. 定义双指针 `l`，`r`，同时取得需要匹配的字母数量 `map.size()`。
3. 使用右指针 `l` 遍历需要匹配的数组 `p`，如果当前字符能在 `map` 中找到，则让该字符对应的值减一，剪完如果变成 0 了，就让 `count` 减一。
```java
while (r < sLen) {
    char c = s.charAt(r);
    if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) count--;
    }
    r++;
} 
```
4. 当 `count` 为 0，即已经匹配完了需要匹配的所有字符，让左端点 `l` 左移，将对应字符滑出窗口，滑出时要让这个字符对应的值 + 1，如果加完之后对应值不为 0 了，`count` 就要加一（需要匹配的字符量加一了）。
```java
while (count == 0) {
    char temp = s.charAt(l);
    if (map.containsKey(temp)) {
        map.put(map.get(temp) + 1);
        if (map.get(temp) > 0) count++;
    }
    l++;
}
```

### 扩展
[滑动窗口](https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.)