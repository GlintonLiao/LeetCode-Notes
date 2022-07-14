class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        vector<int> time(n, 0);
        stack<int> stk;
        int currTime = 0;
        for (auto s : logs)
        {
            int k1 = s.find(":");
            int k2 = s.rfind(":");
            int id = stoi(s.substr(0, k1));
            string mode = s.substr(k1 + 1, 1);
            int ti = stoi(s.substr(k2 + 1));
            if (mode == "s")
            {
                // start
                if (stk.empty())
                {
                    stk.push(id);
                } else 
                {
                    time[stk.top()] += ti - currTime;
                    currTime = ti;
                    stk.push(id);
                }
            } else
            {
                // end
                time[id] += ti - currTime + 1;
                currTime = ti + 1;
                stk.pop();
            }
        }
        return time;
    }
};