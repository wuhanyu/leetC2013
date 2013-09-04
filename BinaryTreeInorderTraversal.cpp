/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
 //Morris Traversal!! very tricky
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> result;
        if(root==0) return result;
        TreeNode* p;
        TreeNode* pre;
    	for(p=root;p!=0;) {
    		if(p->left==0) { result.push_back(p->val); p=p->right; continue; }
    
    		for(pre=p->left;pre->right!=0 && pre->right!=p;pre=pre->right) { }
    
    		if(pre->right==0)
    			{ pre->right=p; p=p->left; continue; }
    		else
    			{ pre->right=0; result.push_back(p->val); p=p->right; continue; }
        }
    }
};
