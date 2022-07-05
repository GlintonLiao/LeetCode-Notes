class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> set;
        for (int n : nums) 
            set.insert(n);
        
        int res;
        for (int n : set)
            if (!set.count(n - 1)) {
                int m = n + 1;
                while (set.count(m)) m++;
                res = max(res, m - n);
            }
        return res;
    }
};