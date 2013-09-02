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
    int flag;
    bool isValidBST(TreeNode *root) {
        flag = -100000;
        return isVBST(root);
    }
    
    bool isVBST(TreeNode *root) {
        if (!root) return true;
        if (!isVBST(root->left)) return false;
        if (flag >= root->val) return false;
        flag = root->val;
        return isVBST(root->right);
    }
};
