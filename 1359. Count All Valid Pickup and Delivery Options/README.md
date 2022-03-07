# 1359. Count All Valid Pickup and Delivery Options

Given `n` orders, each order consist in pickup and delivery services. 

Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i). 

Since the answer may be too large, return it modulo 10^9 + 7.

#### Example 1:

```
Input: n = 1
Output: 1
Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
```

#### Example 2:

```
Input: n = 2
Output: 6
Explanation: All possible orders: 
(P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
```

#### Example 3:

```
Input: n = 3
Output: 90
``` 

#### Constraints:

+ `1 <= n <= 500`

## 解题思路

如果当前已经有 n - 1 个 pairs，我们要加入第 n 个 pair，p[n] 插入的位置有 2n - 1 种可能，d[n] 插入的位置有 2n 种可能。

所以，总共可能的组合插入位置有 (2n - 1) * 2n 种可能。

因为 p 必须大于 d，我们需要将可能性除以 2

所以最终的组合数是 (2n - 1) * n
