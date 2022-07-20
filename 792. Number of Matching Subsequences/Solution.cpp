typedef pair<int, int> PII;

#define x first
#define y second

class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        vector<PII> ps[26];
        int res = 0;
        for (int i = 0; i < words.size(); i++)
        {
            ps[words[i][0] - 'a'].push_back({i, 0});
        }
        for (auto c : s)
        {
            vector<PII> buf;
            for (auto& p : ps[c - 'a'])
            {
                if (p.y == words[p.x].size() - 1) res++;
                else buf.push_back({p.x, p.y + 1});
            }
            ps[c - 'a'].clear();
            for (auto& b : buf)
            {
                ps[words[b.x][b.y] - 'a'].push_back(b);
            }
        }
        return res;
    }
};
