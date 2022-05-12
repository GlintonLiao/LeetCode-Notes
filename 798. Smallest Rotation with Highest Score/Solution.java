class Solution {
    static int N = 100010;
    static int[] arr_diff = new int[N];
    void add(int l, int r) {
        arr_diff[l] += 1; arr_diff[r + 1] -= 1;
        // 差分的更新方式，若要在数组 arr 的 [i, j] 区间同时 + 1，只需要将 将其对应的差分数组 arr_diff[i] + 1, arr_diff[j+1] - 1
        // 本题中 arr[i] 指的是, 当轮调 k = i 的时候，有 arr[i] 个元素能够满足轮调后的条件，等价于得分
    }
    public int bestRotation(int[] nums) {
        Arrays.fill(arr_diff, 0);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = (i - (n - 1) + n) % n, b = (i - nums[i] + n) % n;  // 对于当前的 nums[i] 能够得分的 k 的取值区间 左 右边界
            if (a <= b) {
                add(a, b);
                // 通过差分数组更新，对应 原数组arr 的操作就是，给 arr的[a, b] 区间的所有元素 + 1; 也就是说, 当 k 取值 在 [a,b] 区间内的时候，论调后，当前的nums[i] 是可以 满足条件的，为 k = i 后的得分助力。
            } else {
                add(0, b);
                add(a, n - 1);
            }
        }

        // 这里已经将 arr_diff 进行了还原，我们为了清楚，给他重新命名
        for (int i = 1; i <= n; i++) arr_diff[i] += arr_diff[i - 1];  // 差分进行还原，得到的 arr[i] 表示的是 轮调 k = i 的时候，能够得分的 nums[i] 的个数，也就是得分结果

        int[] arr = arr_diff;  // 重新命名为 arr
        int ans_k = 0, score = arr[0]; // ans_k 指的就是轮调数 k
        for (int i = 1; i <= n; i++) {
            if (arr[i] > score) {  // 为了保证 k 最小，这里取大于号
                score = arr[i]; ans_k = i;
            }
        }
        return ans_k;
    }
}