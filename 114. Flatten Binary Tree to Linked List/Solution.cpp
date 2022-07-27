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
private:
    TreeNode *pre = NULL;
public:
    void flatten(TreeNode* root) {
        if (!root) return;

        if (pre){
            pre->right = root;
            pre->left = NULL;
        }

        pre = root;
        TreeNode *left = root->left, *right = root->right;
        flatten(left);
        flatten(right);
    }
};