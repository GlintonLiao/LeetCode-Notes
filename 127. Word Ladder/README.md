# 127. Word Ladder

A transformation sequence from word `beginWord` to word endWord using a dictionary `wordList` is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:

+ Every adjacent pair of words differs by a single letter.
+ Every si for `1 <= i <= k` is in `wordList`. Note that beginWord does not need to be in `wordList`.
+ `sk == endWord`

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return the **number of words** in the **shortest transformation sequence** from `beginWord` to `endWord`, or `0` if no such sequence exists.

#### Example 1

```
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
```

#### Example 2

```
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
```

## 解题思路

这道题很难，可以说总结不出什么通用的套路。

整道题的流程是这样的：

1. 遍历 `beginWord` 的每一个字符，改变这个字符，检测 `wordList` 中有没有这个字符

2. 如果有，把新的字符加入 `beginWord` 的集合，作为新的 `beginWord`，整体 `len + 1`（也就是检测改变一个字符的情况下，`wordList` 中存在的解）

3. 重复上述过程，如果某一次的解是 `endWord`，返回 `len`；直到 `beginWord` 没有新的解，返回 `0`；

Solution 里面的解法是每次只遍历单词数量比较少的那个 `set`，能提高效率。因为随着上述过程的进行 `beginWord` 的集合可能会变的很大，遍历起来效率就低了。