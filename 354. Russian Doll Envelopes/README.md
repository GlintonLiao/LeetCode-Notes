# 354. Russian Doll Envelopes

You are given a 2D array of integers `envelopes` where `envelopes[i] = [wi, hi]` represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

#### Note: 
You cannot rotate an envelope.


#### Example 1:

```
Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
```

#### Example 2:

```
Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1
``` 

#### Constraints:

+ `1 <= envelopes.length <= 10^5`
+ `envelopes[i].length == 2`
+ `1 <= wi, hi <= 10^5`

## 解题思路

将长边升序排序，这样可以确保长边都可以套进去，然后对短边求一次最长上升子序列。

最巧妙的地方在于，升序排序长边时，相同长度的长边要降序排序，这样可以确保在求子序列的时候能够排除当前这项（长边相同是套不进去的）。
