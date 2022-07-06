class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int two = INT_MIN;
        stack<int> stack;
        int n = nums.size();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < two) return true;
            while (!stack.empty() && stack.top() < nums[i]) {
                two = stack.top();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
};