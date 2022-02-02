# 121. Best Time to Buy and Sell Stock

## 题目描述

You are given an array prices where `prices[i]` is the price of a given stock on the ith day.

You want to maximize your profit by choosing a **single** day to buy one stock and choosing a **different day in the future** to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

## 解题思路

用动态规划的思想来思考这一题。

### 状态表示

**集合划分**

`f[i]` 表示第 `i` 天所有操作的利润。

**集合属性**

`Max` 利润最大值

### 状态计算

1. 操作可以被划分成两种，一种是卖出，一种是不卖出。
* 不卖：利润为 0
* 卖：利润为前一天的最大利润 `f[i - 1]` + 今天卖出的利润 `prices[i]` - 昨天卖出的利润 `prices[i - 1]`

2. 取以上两种操作的最大值，就是今天所有操作的利润最大值。

状态计算公式为:
```java
f[i] = Math.max(0, f[i - 1] + prices[i] - prices[i - 1]);
```

3. 最后结果为 `f[1] - f[f.length - 1]` 的最大值。