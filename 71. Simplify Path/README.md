# 71. Simplify Path

Given a string `path`, which is an **absolute path** (starting with a slash `'/'`) to a file or directory in a Unix-style file system, convert it to the simplified **canonical path**.

In a Unix-style file system, a period `'.'` refers to the current directory, a double period `'..'` refers to the directory up a level, and any multiple consecutive slashes (i.e. `'//'`) are treated as a single slash `'/'`. For this problem, any other format of periods such as `'...'` are treated as file/directory names.

The canonical path should have the following format:

+ The path starts with a single slash `'/'`.
+ Any two directories are separated by a single slash `'/'`.
+ The path does not end with a trailing `'/'`.
+ The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period `'.'` or double period `'..'`)

Return the *simplified* **canonical path**. 

#### Example 1:

```
Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
```

#### Example 2:

```
Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
```

#### Example 3:

```
Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
``` 

#### Constraints:

+ `1 <= path.length <= 3000`
+ path consists of English letters, digits, period `'.'`, slash `'/'` or `'_'`.
+ path is a valid absolute Unix path.

## 解题思路

这一题思路比较简单，主要是考察 API 的熟练程度

首先，把原始路径按照 '/' 分隔成一个数组

遍历这个数组，如果符合要求就推入队列，如果是跳出当前路径就从队列中推出一个元素。

最后，从尾到头遍历整个队列，加进 StringBuilder，返回 StringBuilder 的 String 形式。
