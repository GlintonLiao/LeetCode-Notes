# 2062. Count Vowel Substrings of a String

A **substring** is a contiguous (non-empty) sequence of characters within a string.

A **vowel substring** is a substring that **only** consists of vowels (`'a'`, `'e'`, `'i'`, `'o'`, and `'u'`) and has **all five** vowels present in it.

Given a string word, return the number of **vowel substrings** in word.

#### Example 1:

```
Input: word = "aeiouu"
Output: 2
Explanation: The vowel substrings of word are as follows (underlined):
- "aeiouu"
- "aeiouu"
```

#### Example 2:

```
Input: word = "unicornarihan"
Output: 0
Explanation: Not all 5 vowels are present, so there are no vowel substrings.
```

#### Example 3:

```
Input: word = "cuaieuouac"
Output: 7
Explanation: The vowel substrings of word are as follows (underlined):
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
``` 

#### Constraints:

+ `1 <= word.length <= 100`
+ `word` consists of lowercase English letters only.

## 解题思路

遍历所有可能的起点，每一个起点做一个 set，用第二个指针向后遍历，满足条件就加到 set 里，如果 set 的容量是 5，res++

如果遍历途中发现不符合条件，直接 break，去下一个起点。