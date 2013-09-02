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
    bool isBalanced(TreeNode *root) {
        initHeight(root);
        return isB(root);
    }
    
    bool isB(TreeNode *root){
        if (!root) return true;
        if (abs(getHeight(root->left) - getHeight(root->right)) <= 1 && isB(root->left) && isB(root->right)) return true;
        return false;
    }
    
    int getHeight(TreeNode *e){
        if (!e) return 0;
        return e->val;
    }
    
    int initHeight(TreeNode *root) {
        if (!root) return 0;
        root->val = max(initHeight(root->left), initHeight(root->right)) + 1;
        return root->val;
    }
};
