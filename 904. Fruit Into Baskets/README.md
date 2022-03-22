# 904. Fruit Into Baskets

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits` where `fruits[i]` is the **type** of fruit the `ith` tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

+ You only have **two** baskets, and each basket can only hold a **single type** of fruit. There is no limit on the amount of fruit each basket can hold.
+ Starting from any tree of your choice, you must pick **exactly one** fruit from **every** tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
+ Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Given the integer array `fruits`, return the **maximum** number of fruits you can pick.

#### Example 1:

```
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
```

#### Example 2:

```
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
```

#### Example 3:

```
Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
``` 

#### Constraints:

+ `1 <= fruits.length <= 105`
+ `0 <= fruits[i] < fruits.length`

## 解题思路

说了一堆，其实就是「最多出现两个不同字母的区间最大值」，所以用滑动窗口去维护就好了。

在滑动的过程中，我们不能在左端点更新时才去 Update 答案，因为有可能整个数组可以被全包进来，左端点根本没有更新的机会，此时的答案就是数组长度。
