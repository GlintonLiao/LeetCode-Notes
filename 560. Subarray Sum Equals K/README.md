# 560. Subarray Sum Equals K

Given an array of integers `nums` and an integer `k`, return the total number of continuous *subarrays* whose sum equals to `k`.

#### Example 1

```
Input: nums = [1,1,1], k = 2
Output: 2
```

#### Example 2

```
Input: nums = [1,2,3], k = 3
Output: 2
```

## 解题思路

因为求的是连续子串的和，所以不能用 DFS，应该用前缀和去做。

求出每一项的前缀和，然后就是一个 twoSum 问题。

TwoSum 问题的通用方法是：

```java
Map<Integer, Integer> map = new HashMap<>();
int res = 0;

for (int n : nums) {

    // 检测目标值是否存在
    target = ...(用 n 和 k 得出);
    if (map.containsKey(target)) res += map.get(target); // 具体逻辑

    // 将当前值放入 map
    map.put(n, getOrDefault(n, 0) + 1);

}
```

时间复杂度为 `O(n)`。
