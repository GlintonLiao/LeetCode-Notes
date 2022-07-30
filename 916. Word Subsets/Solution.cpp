class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        unordered_map<char, int> max_cnt;
        for (auto& s : words2)
        {
            unordered_map<char, int> map;
            for (auto& c : s) map[c]++;
            for (auto [k, v] : map) max_cnt[k] = max(max_cnt[k], v);
        }
        
        vector<string> res;
        for (auto& s : words1)
        {
            unordered_map<char, int> map;
            for (auto& c : s) map[c]++;
            bool flag = true;
            for (auto [k, v] : max_cnt)
            {
                if (map[k] < v) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.push_back(s);
        }
        return res;
    }
};