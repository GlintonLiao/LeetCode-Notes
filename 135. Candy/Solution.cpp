class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        vector<int> num(n, 1);
        
        for (int i = 1; i < n; i++) 
            if (ratings[i] > ratings[i - 1])
                num[i] = num[i - 1] + 1;
        
        for (int i = n - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                num[i] = max(num[i + 1] + 1, num[i]);
        
        int res = 0;
        for (int c : num)
            res += c;
        
        return res;
    }
};