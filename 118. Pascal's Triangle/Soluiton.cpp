class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        if (!numRows) return res;
        res.push_back(vector<int>(1, 1));
        for (int i = 1; i < numRows; i ++ )
        {
            vector<int> &last = res.back();
            vector<int> temp;
            temp.push_back(1);
            for (int i = 0; i + 1 < last.size(); i ++ )
                temp.push_back(last[i] + last[i + 1]);
            temp.push_back(1);
            res.push_back(temp);
        }
        return res;
    }
};
