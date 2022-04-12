# 318. Maximum Product of Word Lengths

Given a string array `words`, return the maximum value of `length(word[i]) * length(word[j])` where the two words do not share common letters. If no such two words exist, return `0`.

#### Example 1:

```
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
```

#### Example 2:

```
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
```

#### Example 3:

```
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
``` 

#### Constraints:

+ `2 <= words.length <= 1000`
+ `1 <= words[i].length <= 1000`
+ `words[i]` consists only of lowercase English letters.

## 解题思路

对于每一个单词，都可以把它转化为一个长度为 26 的二进制数字，每一位代表对应的字母是否有出现在单词中。

得到二进制转化过后的单词，我们就可以进行按位与操作，如果两个单词没有重复的字母，则结果应该是 0。
