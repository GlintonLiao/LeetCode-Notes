# 991. Broken Calculator

There is a broken calculator that has the integer `startValue` on its display initially. In one operation, you can:

+ multiply the number on display by `2`, or
subtract 1 from the number on display.
+ Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

#### Example 1:

```
Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
```

#### Example 2:

```
Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
```

#### Example 3:

```
Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
``` 

#### Constraints:

+ `1 <= x, y <= 10^9`

## 解题思路

我们可以反向思考，把 `target` 一步一步往 `start` 靠。如果 `target` 是偶数，那么一定是 从 `target / 2` 过来速度最快；如果是奇数，则一定是从 `target + 1` 过来最快。

通过递归倒推 `startValue`，每次加 `1`，直到 `start == target` 即可。
