# 524. Longest Word in Dictionary through Deleting

Given a string `s` and a string array `dictionary`, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

#### Example 1:

```
Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
```

#### Example 2:

```
Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
``` 

#### Constraints:

+ `1 <= s.length <= 1000`
+ `1 <= dictionary.length <= 1000`
+ `1 <= dictionary[i].length <= 1000`
+ `s` and `dictionary[i]` consist of lowercase English letters.

## 解题思路

不需要排序，只需要检测比当前最优解更长的字符串，符合条件就更新当前最优解。
