class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> f(n);
        for (int i = 0; i < n; ++i) {
            f[i] = nums[i]; // 因为队列只保存下标，所以f[i]初始化为nums[i]的值，方便取元素计算
        }
        deque<int> q;
        q.push_back(0);
        for (int i = 1; i < n; ++i) {
            while (q.size() && i - q.front() > k) { // 取出队头合法元素
                q.pop_front();
            }
            f[i] = f[q.front()] + nums[i]; // 计算答案
            while (q.size() && f[i] > f[q.back()]) { // 找到插入位置
                q.pop_back();
            }
            q.push_back(i); // 插入
        }
        return f[n - 1];
    }
};