# 1353. Maximum Number of Events That Can Be Attended
## 题目描述
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.

```
Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
```

## 解题思路

#### 思考

对于满足范围的每一天来说，只要当前这一天能清掉一个区间，就清掉一个（贪心）。

所以，我们需要在每一天加入所有从这一天开始可以被清掉的区间，以及去除在这一天已经超出区间右端点的区间。

如果此时堆不为空，则可以清掉一个区间，同时结果加一。

#### 步骤

1. 按照区间左端点排序
2. 做一个最小堆，存储满足条件的区间右端点
3. 遍历范围内的每一天，把今天开始的区间右端点加入最小堆（最先结束的区间会排在最前面）
4. 如果有区间的右端点已经小于今天，说明这个区间已经不能再用了，就清掉。
5. 如果堆内还有元素，则弹出一个元素，同时让结果加一。
6. 返回结果。