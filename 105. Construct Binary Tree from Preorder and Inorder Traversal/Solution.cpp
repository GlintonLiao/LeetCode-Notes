/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    unordered_map<int, int> map;
    
    TreeNode* build(vector<int>& pre, vector<int>& in, int l1, int r1, int l2, int r2) 
    {
        if (l1 > r1) return NULL;
        TreeNode* root = new TreeNode(pre[l1]);
        int k = map[pre[l1]] - l2;
        root->left = build(pre, in, l1 + 1, l1 + k, l2, l2 + k - 1);
        root->right = build(pre, in, l1 + k + 1, r1, l2 + k + 1, r2);
        return root;
    }
    
    TreeNode* buildTree(vector<int>& pre, vector<int>& in) {
        int n = pre.size();
        for (int i = 0; i < n; i++)
        {
            map[in[i]] = i;
        }
        return build(pre, in, 0, n - 1, 0, n - 1);
    }
};