class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size(), m = matrix[0].size();
        for (int i = 0; i < n; i++)
        {
            if (target < matrix[i][0] || target > matrix[i][m - 1])
                continue;
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (matrix[i][mid] >= target)
                {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (matrix[i][l] == target) return true;
        }
        return false;
    }
};
