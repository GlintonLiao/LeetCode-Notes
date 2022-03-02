# 911. Online Election

You are given two integer arrays `persons` and `times`. In an election, the ith vote was cast for `persons[i]` at time `times[i]`.

For each query at a time `t`, find the person that was leading the election at time `t`. Votes cast at time `t` will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.

Implement the `TopVotedCandidate` class:

+ `TopVotedCandidate(int[] persons, int[] times)` Initializes the object with the `persons` and `times` arrays.

+ `int q(int t)` Returns the number of the person that was leading the election at time `t` according to the mentioned rules.

#### Example 1

```
Input
["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
[[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
Output
[null, 0, 1, 1, 0, 0, 1]

Explanation
TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
topVotedCandidate.q(3); // return 0, At time 3, the votes are [0], and 0 is leading.
topVotedCandidate.q(12); // return 1, At time 12, the votes are [0,1,1], and 1 is leading.
topVotedCandidate.q(25); // return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
topVotedCandidate.q(15); // return 0
topVotedCandidate.q(24); // return 0
topVotedCandidate.q(8); // return 1
```

#### Constraints:

+ `1 <= persons.length <= 5000`
+ `times.length == persons.length`
+ `0 <= persons[i] < persons.length`
+ `0 <= times[i] <= 109`
+ `times` is sorted in a strictly increasing order.
+ `times[0] <= t <= 109`
+ At most `10^4` calls will be made to `q`.

## 解题思路

这道题最难的地方在于读懂题......

一开始不知道 input 是啥意思，以为 `person` 数组的每个人都是独立的人，但其实 `0` 和 `1` 就代表两个人而已，在 `times` 数组中的时间标记着此时会给 `person` 数组对应位置的人投一票。

因为 `person` 从 `0` 开始，所以我们可以直接用一个 `count` 数组来记录每个人的票数。

然后我们遍历时间序列的每一项，动态地更新当前的 `leader`，把 `leader` 和时间对应起来存在 `map` 里。

之后，`query(int t)` 中，因为 `times` 数组是单调递增的（一开始看题看岔了，以为是打乱的......），所以我们可以对 `times` 数组进行二分查找，找到 `t` 所属的**时间段**内最靠前的**时间点**，在 map 中寻找这个时间点对应的 `leader` 即可。
