# 881. Boats to Save People

You are given an array `people` where `people[i]` is the weight of the `ith` person, and an infinite number of boats where each boat can carry a maximum weight of `limit`. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most `limit`.

Return *the minimum number of boats* to carry every given person. 

#### Example 1:

```
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
```

#### Example 2:

```
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
```

#### Example 3:

```
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
``` 

#### Constraints:

+ `1 <= people.length <= 5 * 10^4`
+ `1 <= people[i] <= limit <= 3 * 10^4`

## 解题思路

双指针，首先将数组排序，然后左右指针分别指向两个端点。

如果双指针之和满足 limit，就两个指针同时往中间移动。

如果不满足，则只移动较大的右指针。

最后，右指针走过的数量就是小船的数量，因为左右指针可能出现相等的情况，但不管怎样，左指针的位置是固定的，所以我们可以用左指针来计算。
