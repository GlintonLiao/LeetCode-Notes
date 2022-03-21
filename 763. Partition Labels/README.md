# 763. Partition Labels

You are given a string `s`. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be `s`.

Return *a list of integers representing the size of these parts*.

#### Example 1:

```
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
```

#### Example 2:

```
Input: s = "eccbbbbdec"
Output: [10]
``` 

#### Constraints:

+ `1 <= s.length <= 500`
+ `s` consists of lowercase English letters.

## 解题思路

我们可以把这一题转化为一道区间的问题，如果一个区间包不住另一个区间（新区间左端点大于现区间右端点），我们就把现区间加进答案，然后把新区间作为现区间，继续往下寻找。

对于这道题来说，我们可以先统一一下每个字母最后一次出现的位置，也就找到了每个字母区间的右端点。随后遍历一次字符串，按照上述原则不断更新区间右端点和答案即可。
