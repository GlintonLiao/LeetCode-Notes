# 847. Shortest Path Visiting All Nodes

You have an undirected, connected graph of `n` nodes labeled from `0` to `n - 1`. You are given an array `graph` where `graph[i]` is a list of all the nodes connected with node `i` by an edge.

Return *the length of the shortest path that visits every node*. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

#### Example 1

![example img](https://assets.leetcode.com/uploads/2021/05/12/shortest1-graph.jpg)

```
Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
```

#### Example 2

![example img](https://assets.leetcode.com/uploads/2021/05/12/shortest2-graph.jpg)

```
Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
```

#### Constraints

+ `n == graph.length`
+ `1 <= n <= 12`
+ `0 <= graph[i].length < n`
+ `graph[i]` does not contain `i`.
+ If `graph[a]` contains b, then `graph[b]` contains `a`.
+ The input graph is always connected.

## 解题思路

BFS，最骚的操作是使用 bitMask 来检测是否所有点都已经被遍历过。

假设 n == 5，一共有 5 个点，则：

1 << n 是 100000
(1 << n) - 1 是 11111，就是最终状态。

在每次遍历时，假设现在的点是 1（i == 1），则现在的状态是 1 >> i == 10，即位置为 1 的点被选中。

在每次拓展时，bitMask | (1 << 当前点 v)，表示 bitMask 的第 v 位会变成 1，代表被选中。
