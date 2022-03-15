# 443. String Compression

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string `s`. For each group of **consecutive repeating characters** in chars:

+ If the group's length is `1`, append the character to `s`.
+ Otherwise, append the character followed by the group's length.

The compressed string `s` **should not be returned separately**, but instead, be stored in the input character array chars. Note that group lengths that are `10` or longer will be split into multiple characters in chars.

After you are done **modifying the input array**, return *the new length of the array*.

You must write an algorithm that uses only constant extra space.

#### Example 1:

```
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
```

#### Example 2:

```
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
```

#### Example 3:

```
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
``` 

#### Constraints:

+ `1 <= chars.length <= 2000`
+ `chars[i]` is a lowercase English letter, uppercase English letter, digit, or symbol.

## 解题思路

将原数组作为我们的新数组，可以确定的是，新数组的 idx 一定不会覆盖掉当前的原数组，因为 idx 向前移动的次数总是会小于等于窗口向前移动的次数。

同时，我们维护一个 i、j 的窗口，将 i 和次数 j - i（需要转换为字符串）放在原数组对应的位置即可。

最后我们返回 idx，即新数组的长度。
