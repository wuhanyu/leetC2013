/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        vector<vector<int>> result;
        vector<int> list;
        if (root) findPathSum(root, sum, list, result);
        return result;
    }
    
    void findPathSum(TreeNode *root, int sum, vector<int> &list, vector<vector<int>> &result){
        list.push_back(root->val);
        if (!root->left && !root->right && sum == root->val) result.push_back(list);
        if (root->left) findPathSum(root->left, sum - root->val, list, result);
        if (root->right) findPathSum(root->right, sum - root->val, list, result);
        list.pop_back();
        return;
    }
};
