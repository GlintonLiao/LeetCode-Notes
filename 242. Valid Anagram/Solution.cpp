class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        vector<int> cnt(26);
        for (auto c : s)
        {
            cnt[c - 'a']++;
        }
        for (auto c : t)
        {
            // cout << cnt[c - 'a'] << endl;
            if (cnt[c - 'a'] == 0) return false;
            cnt[c - 'a']--;
        }
        return true;
    }
};
